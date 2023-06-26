package com.dh.store.carRent.repository;

import com.dh.store.carRent.model.EstadoReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReservaModel, Long> {

}
