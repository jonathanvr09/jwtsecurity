package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.model.CategoriaModel;
import com.dh.store.carRent.repository.CategoriaRepository;
import com.dh.store.carRent.service.CategoriaService;
import com.dh.store.carRent.service.VehiculoService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    private Logger logger = LoggerFactory.getLogger(VehiculoService.class);
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }
    @Override
    public ArrayList<CategoriaModel> listar() {
        return (ArrayList<CategoriaModel>) categoriaRepository.findAll();
    }

    @Override
    public CategoriaModel crear(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public boolean eliminar(Long id){
        if (id == null)
            return false;
        else
            categoriaRepository.eliminar(id);
        return true;
    }

    @Override
    public ArrayList<CategoriaModel> listarById(@PathVariable Long id) {
        return null;
    }
}
