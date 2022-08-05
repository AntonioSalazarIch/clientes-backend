package com.et.clientes.backend.security.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
public class User {

    @Column( unique = true, length = 20 )
    private String username;

    @Column( length = 60 )
    private String password;

    private Boolean enabled;

    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable( name = "users_roles",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "role_id" ),
            uniqueConstraints = { @UniqueConstraint( columnNames = { "user_id", "role_id" } ) }
    )
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
