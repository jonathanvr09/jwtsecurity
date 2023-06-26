package com.dh.store.carRent.service;

import com.dh.store.carRent.model.MedioPagoModel;
import java.util.ArrayList;

public interface MedioPagoService {
    public ArrayList<MedioPagoModel> listar();
    public MedioPagoModel crear(MedioPagoModel mediPago);
}
