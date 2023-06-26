package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.dto.AuthenticationResponse;
import com.dh.store.carRent.dto.LoginRequest;
import com.dh.store.carRent.dto.OnRegistrationCompleteEvent;
import com.dh.store.carRent.dto.SignUpRequest;
import com.dh.store.carRent.exceptions.InvalidTokenException;
import com.dh.store.carRent.exceptions.TokenExpiredException;
import com.dh.store.carRent.jwt.JwtService;
import com.dh.store.carRent.model.VerificationToken;
import com.dh.store.carRent.repository.VerificationTokenRepository;
import com.dh.store.carRent.service.AuthenticationService;
import com.dh.store.carRent.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
@Transactional
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final VerificationTokenRepository tokenRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword()));

        String jwt =jwtService
                .generateToken((UserDetails) authentication.getPrincipal());

        return AuthenticationResponse.builder()
                .jwt(jwt)
                .build();
    }

    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest, WebRequest request) {
        UserDetails userDetails = usuarioService.signUp(signUpRequest);

        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(userDetails, request.getLocale(), request.getContextPath()));

        return AuthenticationResponse.builder()
                .jwt(jwtService.generateToken(userDetails))
                .build();
    }
}
