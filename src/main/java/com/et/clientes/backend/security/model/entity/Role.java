package com.et.clientes.backend.security.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "roles" )
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "name_role", unique = true, length = 20 )
    private String nameRole;
    private String description;

    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable( name = "roles_permissions",
            joinColumns = @JoinColumn( name = "role_id" ),
            inverseJoinColumns = @JoinColumn( name = "permission_id" ),
            uniqueConstraints = { @UniqueConstraint( columnNames = { "role_id", "permission_id" } ) }
    )
    private List<Permission> permissions;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
