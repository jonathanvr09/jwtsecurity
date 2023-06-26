package com.dh.store.carRent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estado_reserva")
public class EstadoReservaModel {
    @Id
    @GeneratedValue
    @Column(name = "id_estado")
    private Long idEstado;
    private String estado;
}
