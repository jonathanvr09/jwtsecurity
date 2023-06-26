package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.dto.OnRegistrationCompleteEvent;
import com.dh.store.carRent.exceptions.InvalidTokenException;
import com.dh.store.carRent.exceptions.TokenExpiredException;
import com.dh.store.carRent.model.VerificationToken;
import com.dh.store.carRent.repository.VerificationTokenRepository;
import com.dh.store.carRent.service.AccountActivationService;
import com.dh.store.carRent.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
@Transactional
@AllArgsConstructor
public class AccountActivationServiceImpl implements AccountActivationService {

    private final VerificationTokenRepository tokenRepository;

    private final UsuarioService userService;

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void createVerificationToken(UserDetails userDetails, String token) {
        VerificationToken myToken = new VerificationToken(token, userDetails);
        tokenRepository.save(myToken);
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void verifyTokenValidityAndExpiration(VerificationToken verificationToken, UserDetails userDetails) throws InvalidTokenException, TokenExpiredException {

        if (verificationToken == null) {
            throw new InvalidTokenException("Invalid token!");
        }

        LocalDateTime expiryDate = verificationToken.getExpiryDate();
        LocalDateTime currentTime = LocalDateTime.now();
        if (expiryDate.isBefore(currentTime)) {
            this.expiredAccount(userDetails);
            throw new TokenExpiredException("The token has expired! You need to register again.");
        }

    }

    @Override
    public String registrationConfirm(String token, Locale locale) throws InvalidTokenException, TokenExpiredException {
        VerificationToken verificationToken = this.getVerificationToken(token);

        UserDetails userDetails = verificationToken.getUser();

        this.verifyTokenValidityAndExpiration(verificationToken, userDetails);

        userService.registrationConfirm(userDetails);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(userDetails));

        return "Account Confirmed!";
    }

    @Override
    public void expiredAccount(UserDetails userDetails){
        userService.setAccountExpired(userDetails);
    }

    @Override
    public String resendConfirmationEmail(WebRequest request, String email){
        UserDetails userDetails = userService.getUserByEmail(email);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(userDetails, request.getLocale(), request.getContextPath()));
        return "Confirmation Email Sent!";
    }
}
