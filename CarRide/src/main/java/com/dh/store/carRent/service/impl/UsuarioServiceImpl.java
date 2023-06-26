package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.dto.PageResponseDTO;
import com.dh.store.carRent.dto.SignUpRequest;
import com.dh.store.carRent.dto.UserDTO;
import com.dh.store.carRent.model.Role;
import com.dh.store.carRent.model.UsuarioModel;
import com.dh.store.carRent.repository.UsuarioRepository;
import com.dh.store.carRent.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import java.util.ArrayList;
import java.util.Optional;

import static com.dh.store.carRent.model.Role.USER;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConversionService conversionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails userDetails = usuarioRepository.getFirstByName(userName);
        if (userDetails ==null){
            throw new UsernameNotFoundException(userName);
        }
        return userDetails;
    }


    @Override
    public ArrayList<UsuarioModel> listar() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel crear(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean eliminar(String email){
        if (email == null)
            return false;
        else
            usuarioRepository.eliminar(email);
        return true;
    }

    @Override
    public void registrationConfirm(UserDetails userDetails) {
        UsuarioModel user = (UsuarioModel) userDetails;
        user.setIsAccountVerified(true);
        usuarioRepository.save(user);
    }

    @Override
    public UserDetails createUser(SignUpRequest signUpRequest) {
        try{
            return usuarioRepository.save(UsuarioModel.builder()
                    .nombre(signUpRequest.getName())
                    .contrasenia(passwordEncoder.encode(signUpRequest.getPassword()))
                    .enabled(true)
                    .role(USER)
                    .build());
        }catch (DataIntegrityViolationException e){
            throw new ErrorResponseException(HttpStatus.CONFLICT,
                    ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,
                            "User already exist"),e);
        }
    }

    @Override
    public UserDetails getUserByEmail(String email){
        return this.findUserByEmail(email);

    }

    @Override
    public UserDetails signUp(SignUpRequest signUpRequest) {
        try {

            UsuarioModel user = findUserByEmail(signUpRequest.getEmail());

            if (user != null && !user.isAccountNonExpired()) {
                user.setIsAccountExpired(false);
                return usuarioRepository.save(user);
            } else {
                return usuarioRepository.save(UsuarioModel.builder()
                        .nombre(signUpRequest.getName())
                        .apellido(signUpRequest.getLastName())
                        .email(signUpRequest.getEmail())
                        .contrasenia(passwordEncoder.encode(signUpRequest.getPassword()))
                        .role(Role.USER)
                        .isAccountVerified(false)
                        .isAccountExpired(false)
                        .build());
            }
        } catch (DataIntegrityViolationException e) {
            throw new ErrorResponseException(HttpStatus.CONFLICT,
                    ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,
                            "User already exist"), e);
        }
    }

    private UsuarioModel findUserByEmail(String email){
        Optional<UsuarioModel> optionalUser = usuarioRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public PageResponseDTO<UserDTO> getUsers(Pageable pageable) {
        Page<UsuarioModel> userPage = usuarioRepository.findAll(pageable);
        return new PageResponseDTO<>(
                userPage.getContent().stream()
                        .map(user -> conversionService.convert(user, UserDTO.class)).toList()
                , userPage.getPageable()
                , userPage.getTotalPages());
    }

    @Override
    public void setAccountExpired(UserDetails userDetails){

        UsuarioModel user = findUserByEmail(userDetails.getUsername());

        if(user != null){
            user.setIsAccountExpired(true);
            usuarioRepository.save(user);
        }

    }
}