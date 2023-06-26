package com.dh.store.carRent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reserva")
public class ReservaModel {
    @Id
    @GeneratedValue
    @Column(name = "id_reserva")
    private Long idReserva;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    private Date fechaFin;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioModel idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private VehiculoModel idVehiculo;
    @ManyToOne
    @JoinColumn(name = "id_medioPago")
    private MedioPagoModel idMedioPagp;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoReservaModel idEstado;
}
