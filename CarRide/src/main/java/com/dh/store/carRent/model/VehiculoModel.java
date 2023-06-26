package com.dh.store.carRent.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehiculo")
public class VehiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;
    @Column( name="placa", unique = true, nullable = false)
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    @Column(name = "precio_dia")
    private int precioDia;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria")
    private CategoriaModel categoria;
    @Column(name = "url_imagen")
    private String urlImagen;
}
