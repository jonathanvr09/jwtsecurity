package com.dh.store.carRent.controller;

import com.dh.store.carRent.model.ReservaModel;
import com.dh.store.carRent.model.VehiculoModel;
import com.dh.store.carRent.service.UsuarioService;
import com.dh.store.carRent.service.impl.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaServiceImpl reservaService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity <ReservaModel> guardarReserva(@RequestBody ReservaModel reserva, @RequestHeader (name="Authorization") String token){

        return new ResponseEntity<>(reservaService.crearReserva(reserva),HttpStatus.CREATED);
    }

    @GetMapping()
    public List<ReservaModel> obtenerReservas(){
        return reservaService.obtenerReservas();
    }

/*
    @GetMapping("/producto/{id}")
    public List <ReservaModel> obtenerReservasSegunProducto(@PathVariable Long id){
        return reservaService.reservasSegunProducto(id);
    }

    @GetMapping("/usuario/{id}")
    public List <VehiculoModel> obtenerReservasSegunUsuario(@PathVariable Long id){
        return reservaService.reservasSegunUsuario(id);
    }

 */
}