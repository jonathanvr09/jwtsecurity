package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.model.TipoUsuarioModel;
import com.dh.store.carRent.repository.TipoUsuarioRepository;
import com.dh.store.carRent.service.TipoUsuarioService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;

@Service
@Transactional
public class TipoUsuarioServiceImpl implements TipoUsuarioService {
    TipoUsuarioRepository tipoUsuarioRepository;
    private Logger logger = LoggerFactory.getLogger(TipoUsuarioService.class);
    public TipoUsuarioServiceImpl(TipoUsuarioRepository tipoUsuarioRepository){
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public ArrayList<TipoUsuarioModel> listar() {
        return (ArrayList<TipoUsuarioModel>) tipoUsuarioRepository.findAll();
    }

    @Override
    public TipoUsuarioModel crear(TipoUsuarioModel tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public void eliminar(Long id) {
        try{
            tipoUsuarioRepository.deleteById(String.valueOf(id));
            logger.info("Se eliminó el tipo usuario con id {}", id);
        }catch (Exception e){
            logger.error("El tipo usuario con id {} no se puede eliminar", id);
            throw new RuntimeException("El tipo usuario no se pudo eliminar");
        }
    }
    @Override
    public ArrayList<TipoUsuarioModel> listarById(@PathVariable Long id) {
        return null;
    }
}
