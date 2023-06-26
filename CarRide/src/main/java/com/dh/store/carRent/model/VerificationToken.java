package com.dh.store.carRent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken {

    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = UsuarioModel.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UsuarioModel user;

    @JoinColumn(nullable = false, name = "expiry_date")
    private LocalDateTime expiryDate;

    private LocalDateTime calculateExpiryDate(int expiryTimeInMinutes) {
        return LocalDateTime.now().plusMinutes(expiryTimeInMinutes);
    }

    public VerificationToken(String token, UserDetails userDetails) {
        this.token = token;
        this.user = (UsuarioModel) userDetails;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }
}
