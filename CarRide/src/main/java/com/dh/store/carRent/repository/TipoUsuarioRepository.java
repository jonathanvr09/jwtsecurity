package com.dh.store.carRent.repository;

import com.dh.store.carRent.model.TipoUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioModel, String> {
    @Modifying
    @Query(value= "delete from tipoCliente where id_tipo=:id_tipo", nativeQuery = true)
    void eliminar(@Param("id_tipo")Long id_tipo);

    @Modifying
    @Query(value= "mostrar from tipoCliente where id_tipo=:id_tipo", nativeQuery = true)
    void listarById(@Param("id_tipo")Long id_tipo);

}
