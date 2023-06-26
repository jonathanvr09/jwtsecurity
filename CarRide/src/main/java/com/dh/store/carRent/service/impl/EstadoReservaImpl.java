package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.model.EstadoReservaModel;
import com.dh.store.carRent.repository.EstadoReservaRepository;
import com.dh.store.carRent.service.EstadoReservaService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
public class EstadoReservaImpl implements EstadoReservaService {

    private final EstadoReservaRepository estadoReservaRepository;
    private Logger logger = LoggerFactory.getLogger(EstadoReservaService.class);
    public EstadoReservaImpl(EstadoReservaRepository estadoReservaRepository) {
        this.estadoReservaRepository = estadoReservaRepository;
    }
    @Override
    public ArrayList<EstadoReservaModel> listar() {
        return (ArrayList<EstadoReservaModel>) estadoReservaRepository.findAll();
    }

    @Override
    public EstadoReservaModel crear(EstadoReservaModel estadoReserva) {
        return estadoReservaRepository.save(estadoReserva);
    }
}
