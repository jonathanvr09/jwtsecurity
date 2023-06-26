package com.dh.store.carRent.controller;

import com.dh.store.carRent.model.VehiculoModel;
import java.util.ArrayList;
import com.dh.store.carRent.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ArrayList<VehiculoModel> listar(){
        return vehiculoService.listar();
    }

    @PostMapping
    public VehiculoModel crear(@RequestBody VehiculoModel vehiculo){
        return this.vehiculoService.crear(vehiculo);
    }

    @DeleteMapping("/{placa}")
    public boolean eliminar(@PathVariable("placa") String placa) {
        return vehiculoService.eliminar(placa);
    }
}
