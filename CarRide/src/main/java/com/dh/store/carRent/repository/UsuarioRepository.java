package com.dh.store.carRent.repository;

import com.dh.store.carRent.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Modifying
    @Query(value= "delete from usuario where email=:email", nativeQuery = true)
    void eliminar(@Param("email")String email);
    @Query("from User u where u.name =:name")
    UsuarioModel getFirstByName(@Param("name") String name);
    @Query("from User u where u.email =:email")
    Optional<UsuarioModel> findByEmail(@Param("email")String email);
}
