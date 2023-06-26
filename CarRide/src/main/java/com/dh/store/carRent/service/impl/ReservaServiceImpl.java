package com.dh.store.carRent.service.impl;

import com.dh.store.carRent.model.ReservaModel;
import com.dh.store.carRent.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl {

    @Autowired
    private ReservaRepository reservaRepository;
    public ReservaModel crearReserva(ReservaModel reserva){
        return reservaRepository.save(reserva);
    }
    public List <ReservaModel> obtenerReservas(){
        return reservaRepository.findAll();
    }
/*
    public List <ReservaModel> reservasSegunFecha(Date inicio, Date fin){
        return reservaRepository.reservasSegunFecha(inicio,fin);
    }
    public List<ReservaModel> reservasSegunProducto(Long id){
        return reservaRepository.obtenerSegunProducto(id);
    }
    public List <VehiculoModel> reservasSegunUsuario(Long id){
        return reservaRepository.reservasSegunUsuario(id);
    }

 */

}
