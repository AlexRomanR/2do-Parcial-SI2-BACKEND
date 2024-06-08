package com.GestionAsisDocente.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rol_user")
public class RolUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private OurUsers user_id;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Roles rol_id;
}
