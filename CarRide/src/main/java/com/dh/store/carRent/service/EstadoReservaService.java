package com.dh.store.carRent.service;

import com.dh.store.carRent.model.EstadoReservaModel;
import java.util.ArrayList;

public interface EstadoReservaService {
    public ArrayList<EstadoReservaModel> listar();
    public EstadoReservaModel crear(EstadoReservaModel estadoReserva);
}
