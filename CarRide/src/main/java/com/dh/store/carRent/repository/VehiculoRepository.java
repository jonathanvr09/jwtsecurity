package com.dh.store.carRent.repository;

import com.dh.store.carRent.model.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends CrudRepository<VehiculoModel, String>{

    @Modifying
    @Query(value= "delete from vehiculo where placa=:placa", nativeQuery = true)
    void eliminar(@Param("placa")String placa);
}
