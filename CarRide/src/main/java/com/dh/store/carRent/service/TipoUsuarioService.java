package com.dh.store.carRent.service;

import com.dh.store.carRent.model.TipoUsuarioModel;
import java.util.ArrayList;

public interface TipoUsuarioService {
    public ArrayList<TipoUsuarioModel> listar();
    public ArrayList<TipoUsuarioModel> listarById(Long id);
    public TipoUsuarioModel crear(TipoUsuarioModel tipoUsuario);
    public void eliminar(Long id);
}
