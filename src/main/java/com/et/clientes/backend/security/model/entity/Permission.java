package com.et.clientes.backend.security.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "permissions")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "name_permission")
    private String namePermission;

    private String description;
}
