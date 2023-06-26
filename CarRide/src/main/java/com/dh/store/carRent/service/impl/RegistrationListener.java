package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.dto.OnRegistrationCompleteEvent;
import com.dh.store.carRent.exceptions.TokenExpiredException;
import com.dh.store.carRent.model.UsuarioModel;
import com.dh.store.carRent.model.VerificationToken;
import com.dh.store.carRent.service.AccountActivationService;
import com.dh.store.carRent.service.MailService;
import com.dh.store.carRent.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class RegistrationListener implements
        ApplicationListener<OnRegistrationCompleteEvent> {

    private final UsuarioService userService;

    private final MailService mailService;

    private final MessageSource messageSource;

    private final AccountActivationService accountActivationService;


    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {

        if (event.getUserDetails().isEnabled()) {
            this.accountIsConfirmed(event);
        } else{
            try {
                this.confirmRegistration(event);
            } catch (TokenExpiredException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) throws TokenExpiredException {

        UsuarioModel user = (UsuarioModel) event.getUserDetails();
        String token;

        if (user.getVerificationToken() != null) {
            VerificationToken verificationToken = user.getVerificationToken();

            LocalDateTime expiryDate = verificationToken.getExpiryDate();
            LocalDateTime currentTime = LocalDateTime.now();
            if (expiryDate.isBefore(currentTime)) {
                accountActivationService.expiredAccount(event.getUserDetails());
                throw new TokenExpiredException("The token has expired!");
            }

            token = verificationToken.getToken();

        } else{
            UserDetails userDetails = event.getUserDetails();
            token = UUID.randomUUID().toString();
            accountActivationService.createVerificationToken(userDetails, token);
        }


        this.sendConfirmationEmail(user, token, event.getAppUrl());
    }

    private void sendConfirmationEmail(UsuarioModel user, String token, String appUrl){

        String recipientAddress = user.getEmail();
        String subject = messageSource.getMessage("email.confirmation.subject", null, null);
        String confirmationUrl
                = appUrl + "/api/registrationConfirm?token=" + token;
        String message = messageSource.getMessage("email.confirmation.body", new Object[]{user.getNombre(), user.getApellido(), confirmationUrl, subject}, null);

        mailService.sendMail(recipientAddress, subject, message);

    }

    private void accountIsConfirmed(OnRegistrationCompleteEvent event){
        UserDetails userDetails = event.getUserDetails();
        UsuarioModel user = (UsuarioModel) userDetails;

        String recipientAddress = userDetails.getUsername();
        String subject = messageSource.getMessage("email.enabledaccount.subject", null, null);
        String message = messageSource.getMessage("email.enabledaccount.body", new Object[]{user.getNombre(), user.getApellido(), user.getEmail()}, null);

        mailService.sendMail(recipientAddress, subject, message);

    }
}
