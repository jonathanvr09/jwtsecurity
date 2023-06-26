package com.dh.store.carRent.service;

import com.dh.store.carRent.exceptions.InvalidTokenException;
import com.dh.store.carRent.exceptions.TokenExpiredException;
import com.dh.store.carRent.model.VerificationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

public interface AccountActivationService {

    void createVerificationToken(UserDetails userDetails, String token);
    VerificationToken getVerificationToken(String VerificationToken);
    String registrationConfirm(String token, Locale locale) throws InvalidTokenException, TokenExpiredException;
    void expiredAccount(UserDetails userDetails);
    void verifyTokenValidityAndExpiration(VerificationToken verificationToken, UserDetails userDetails) throws InvalidTokenException, TokenExpiredException;
    String resendConfirmationEmail(WebRequest request, String email);

}
