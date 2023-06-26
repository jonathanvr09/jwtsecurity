package com.dh.store.carRent.service;

import com.dh.store.carRent.dto.PageResponseDTO;
import com.dh.store.carRent.dto.SignUpRequest;
import com.dh.store.carRent.dto.UserDTO;
import com.dh.store.carRent.model.UsuarioModel;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface UsuarioService {
    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
    ArrayList<UsuarioModel> listar();
    UsuarioModel crear(UsuarioModel usuario);
    boolean eliminar(String email);

    void registrationConfirm(UserDetails userDetails);
    void setAccountExpired(UserDetails userDetails);
    UserDetails getUserByEmail(String email);
    UserDetails signUp(SignUpRequest signUpRequest);


    UserDetails createUser(SignUpRequest signUpRequest);
    PageResponseDTO<UserDTO> getUsers(Pageable pageable);

}
