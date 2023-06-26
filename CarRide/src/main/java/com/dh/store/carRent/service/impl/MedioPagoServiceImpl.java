package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.model.MedioPagoModel;
import com.dh.store.carRent.repository.MedioPagoRepository;
import com.dh.store.carRent.service.MedioPagoService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@Transactional
public class MedioPagoServiceImpl implements MedioPagoService {

    @Autowired
    private MedioPagoRepository medioPagoRepository;
    private Logger logger = LoggerFactory.getLogger(MedioPagoService.class);

    public MedioPagoServiceImpl(MedioPagoRepository medioPagoRepository) {
        this.medioPagoRepository = medioPagoRepository;
    }

    @Override
    public ArrayList<MedioPagoModel> listar() {
        return null;
    }

    @Override
    public MedioPagoModel crear(MedioPagoModel mediPago) {
        return null;
    }
}
