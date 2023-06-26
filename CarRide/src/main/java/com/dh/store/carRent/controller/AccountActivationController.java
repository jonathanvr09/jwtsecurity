package com.dh.store.carRent.controller;

import com.dh.store.carRent.exceptions.InvalidTokenException;
import com.dh.store.carRent.exceptions.TokenExpiredException;
import com.dh.store.carRent.service.AccountActivationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@AllArgsConstructor
public class AccountActivationController {

    private final AccountActivationService accountActivationService;

    @Operation(summary = "Account confirmation, returns String os Account Confirmed!", responses = {
            @ApiResponse(responseCode = "200",description = "Successful Operation", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content)})
    @GetMapping("/api/registrationConfirm")
    public ResponseEntity<String> accountConfirmation(WebRequest request, @RequestParam("token") String token) throws InvalidTokenException, TokenExpiredException {
        return ResponseEntity.ok(accountActivationService.registrationConfirm(token, request.getLocale()));
    }

    @Operation(summary = "Resend Confirmation Email, returns String of Confirmation Email Sent!")
    @GetMapping("/api/resendConfirmationEmail")
    public ResponseEntity<String> resendConfirmationEmail(WebRequest request,String email) throws InvalidTokenException, TokenExpiredException {
        return ResponseEntity.ok(accountActivationService.resendConfirmationEmail(request, email));
    }


}
