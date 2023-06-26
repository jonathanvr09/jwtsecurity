package com.dh.store.carRent.repository;

import com.dh.store.carRent.model.UsuarioModel;
import com.dh.store.carRent.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    @Query("FROM VerificationToken v WHERE v.user = :user")
    VerificationToken findByUser(@Param("user") UsuarioModel user);
}
