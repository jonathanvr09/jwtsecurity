package com.dh.store.carRent.repository;

import com.dh.store.carRent.model.ReservaModel;
import com.dh.store.carRent.model.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel,Long> {
    /*
    @Modifying
    @Query("select r from Reserva r where productos_id =?1")
    List<ReservaModel> obtenerSegunProducto(Long id);
    @Modifying
    @Query("select r from Reserva r where INICIO_RESERVA BETWEEN ?1 AND ?2 " +
            "OR FIN_RESERVA BETWEEN ?1 AND ?2 " +
            "OR ?1 BETWEEN INICIO_RESERVA AND FIN_RESERVA " +
            "OR ?2 BETWEEN INICIO_RESERVA AND FIN_RESERVA " +
            "ORDER BY PRODUCTOS_ID DESC")
    List <ReservaModel> reservasSegunFecha(Date inicio, Date fin);
    @Modifying
    @Query("select r.productos from Reserva r join r.productos where usuarios_id =?1")
    List <VehiculoModel> reservasSegunUsuario(Long id);
     */
}