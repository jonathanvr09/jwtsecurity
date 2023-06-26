package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.model.VehiculoModel;
import com.dh.store.carRent.repository.VehiculoRepository;
import java.util.ArrayList;
import com.dh.store.carRent.service.VehiculoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;
    private Logger logger = LoggerFactory.getLogger(VehiculoService.class);
    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public ArrayList<VehiculoModel> listar() {
        return (ArrayList<VehiculoModel>) vehiculoRepository.findAll();
    }

    @Override
    public VehiculoModel crear(VehiculoModel vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public boolean eliminar(String placa){
        if (placa == null)
            return false;
        else
            vehiculoRepository.eliminar(placa);
            return true;
    }
}


