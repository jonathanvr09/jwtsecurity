package com.dh.store.carRent.service;

import com.dh.store.carRent.dto.AuthenticationResponse;
import com.dh.store.carRent.dto.LoginRequest;
import com.dh.store.carRent.dto.SignUpRequest;
import org.springframework.web.context.request.WebRequest;

public interface AuthenticationService {
    AuthenticationResponse login(LoginRequest loginRequest);
    AuthenticationResponse signUp(SignUpRequest signUpRequest, WebRequest request);
}
