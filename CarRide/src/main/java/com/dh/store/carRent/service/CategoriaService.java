package com.dh.store.carRent.service;

import com.dh.store.carRent.model.CategoriaModel;
import java.util.ArrayList;

public interface CategoriaService {
    ArrayList<CategoriaModel> listar();
    ArrayList<CategoriaModel> listarById(Long id);
    CategoriaModel crear(CategoriaModel categoria);
    boolean eliminar(Long id);
}
