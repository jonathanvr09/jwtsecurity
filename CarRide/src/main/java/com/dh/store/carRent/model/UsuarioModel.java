package com.dh.store.carRent.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
@Getter
@Setter
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String contrasenia;
    private String direccion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuarioModel tipousuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado_usuario")
    private EstadoUsuarioModel estadousuario;

    @Column(nullable = false)
    private Boolean enabled;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private Boolean isAccountVerified;

    private Boolean isAccountExpired;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VerificationToken verificationToken;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
