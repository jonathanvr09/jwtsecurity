package com.dh.store.carRent.service;

import com.dh.store.carRent.model.EstadoUsuarioModel;
import java.util.ArrayList;

public interface EstadoUsuarioService {
    public ArrayList<EstadoUsuarioModel> listar();
    public EstadoUsuarioModel crear(EstadoUsuarioModel estadoUsuario);
}
