package com.dh.store.carRent.controller;

import com.dh.store.carRent.model.TipoUsuarioModel;
import com.dh.store.carRent.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/tipousuario")
public class TipoUsuarioController {
    @Autowired
    TipoUsuarioService tipoUsuarioService;
    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService){
        this.tipoUsuarioService = tipoUsuarioService;}

    @GetMapping
    public ArrayList<TipoUsuarioModel> listar(){
        return tipoUsuarioService.listar();
    }

    @PostMapping
    public TipoUsuarioModel crear(@RequestBody TipoUsuarioModel tipoUsuario){
        return this.tipoUsuarioService.crear(tipoUsuario);
    }

    @DeleteMapping("/{id_tipo}")
    public ResponseEntity<String> eliminar(@PathVariable("id_tipo") Long id) {
        try{
            this.tipoUsuarioService.eliminar(id);
            return ResponseEntity.ok("TipoUsuario eliminado correctamente");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el TipoUsuario");
        }
    }

    @GetMapping("/{id_tipo}")
    public ArrayList<TipoUsuarioModel> listarById(@PathVariable Long id) {
        return tipoUsuarioService.listarById(id);
    }  // !!!!!!!!!!!!!!   NO IMPRIME POR CONSOLA EL ARREGLO DEL TIPOUSUARIO X ID

}
