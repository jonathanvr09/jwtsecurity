package com.dh.store.carRent.controller;

import com.dh.store.carRent.model.EstadoUsuarioModel;
import com.dh.store.carRent.service.EstadoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
@RequestMapping("/estadousuario")
public class EstadoUsuarioController {
    @Autowired
    EstadoUsuarioService estadoUsuarioService;
    public EstadoUsuarioController(EstadoUsuarioService estadoUsuarioService) {
        this.estadoUsuarioService = estadoUsuarioService;
    }
    @GetMapping
    public ArrayList<EstadoUsuarioModel> listar(){
        return estadoUsuarioService.listar();
    }
    @PostMapping
    public EstadoUsuarioModel crear(@RequestBody EstadoUsuarioModel estadoUsuario){
        return this.estadoUsuarioService.crear(estadoUsuario);
    }
}
