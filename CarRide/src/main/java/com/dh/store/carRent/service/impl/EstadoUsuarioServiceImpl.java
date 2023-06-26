package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.model.EstadoUsuarioModel;
import com.dh.store.carRent.repository.EstadoUsuarioRepository;
import com.dh.store.carRent.service.EstadoUsuarioService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@Transactional
public class EstadoUsuarioServiceImpl implements EstadoUsuarioService {
    private final EstadoUsuarioRepository estadoUsuarioRepository;
    private Logger logger = LoggerFactory.getLogger(EstadoUsuarioService.class);
    public EstadoUsuarioServiceImpl(EstadoUsuarioRepository estadoUsuarioRepository) {
        this.estadoUsuarioRepository = estadoUsuarioRepository;
    }
    @Override
    public ArrayList<EstadoUsuarioModel> listar() {
        return (ArrayList<EstadoUsuarioModel>) estadoUsuarioRepository.findAll();
    }

    @Override
    public EstadoUsuarioModel crear(EstadoUsuarioModel estadoUsuario) {
        return estadoUsuarioRepository.save(estadoUsuario);
    }
}
