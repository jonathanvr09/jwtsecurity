package com.dh.store.carRent.controller;

import com.dh.store.carRent.model.CategoriaModel;
import com.dh.store.carRent.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ArrayList<CategoriaModel> listar(){
        return categoriaService.listar();
    }

    @PostMapping
    public CategoriaModel crear(@RequestBody CategoriaModel categoria){
        return this.categoriaService.crear(categoria);
    }

    @DeleteMapping("/{id}/")
    public boolean eliminar(@PathVariable("id") Long id) {
        return categoriaService.eliminar(id);
    }

    @GetMapping("/{id}")
    public ArrayList<CategoriaModel> listarById(@PathVariable Long id) {
        return categoriaService.listarById(id);
    }

}
