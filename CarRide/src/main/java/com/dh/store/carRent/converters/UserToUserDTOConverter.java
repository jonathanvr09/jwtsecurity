package com.dh.store.carRent.converters;

import com.dh.store.carRent.dto.UserDTO;
import com.dh.store.carRent.model.UsuarioModel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOConverter implements Converter<UsuarioModel, UserDTO> {

    @Override
    public UserDTO convert(UsuarioModel source) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(source.getNombre());
        userDTO.setRole(source.getRole().name());
        return userDTO;
    }
}
