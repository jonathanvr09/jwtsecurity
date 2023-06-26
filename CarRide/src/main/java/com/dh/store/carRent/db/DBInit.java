package com.dh.store.carRent.db;

import com.dh.store.carRent.model.UsuarioModel;
import com.dh.store.carRent.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.dh.store.carRent.model.Role.ADMIN;

@Service
@AllArgsConstructor
public class DBInit implements CommandLineRunner {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        usuarioRepository.save(UsuarioModel.builder()
                .nombre("admin")
                .contrasenia(passwordEncoder.encode("admin"))
                .enabled(true)
                .role(ADMIN)
                .build());
    }
}
