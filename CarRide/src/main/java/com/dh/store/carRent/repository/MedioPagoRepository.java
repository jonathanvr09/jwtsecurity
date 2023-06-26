package com.dh.store.carRent.repository;

import com.dh.store.carRent.model.MedioPagoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioPagoRepository extends JpaRepository<MedioPagoModel, String> {

}
