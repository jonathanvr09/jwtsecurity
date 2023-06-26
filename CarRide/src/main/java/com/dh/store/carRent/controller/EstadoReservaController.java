package com.dh.store.carRent.controller;

import com.dh.store.carRent.model.EstadoReservaModel;
import com.dh.store.carRent.service.EstadoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/estado_reserva")
public class EstadoReservaController {
    @Autowired
    EstadoReservaService estadoReservaService;
    public EstadoReservaController(EstadoReservaService estadoReservaService) {
        this.estadoReservaService = estadoReservaService;
    }
    @GetMapping
    public ArrayList<EstadoReservaModel> listar(){
        return estadoReservaService.listar();
    }
    @PostMapping
    public EstadoReservaModel crear(@RequestBody EstadoReservaModel estadoReserva){
        return this.estadoReservaService.crear(estadoReserva);
    }
}
