package com.dh.store.carRent.service;

import com.dh.store.carRent.model.VehiculoModel;
import java.util.ArrayList;

public interface VehiculoService {
    ArrayList<VehiculoModel> listar();
    VehiculoModel crear(VehiculoModel vehiculo);
    boolean eliminar(String placa);
}
