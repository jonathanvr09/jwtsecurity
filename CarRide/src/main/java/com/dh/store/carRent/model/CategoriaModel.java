package com.dh.store.carRent.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "categoria")
public class CategoriaModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String url;
    @OneToMany(mappedBy = "categoria")
    private Set< VehiculoModel > vehiculos = new HashSet <>();
}
