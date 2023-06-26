package com.dh.store.carRent.repository;

import com.dh.store.carRent.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaModel, Long> {

    @Modifying
    @Query(value= "delete from categoria where id=:id", nativeQuery = true)
    void eliminar(@Param("id")Long id);
    @Modifying
    @Query(value= "mostrar from categoria where id=:id", nativeQuery = true)
    void listarById(@Param("id")int id);
}
