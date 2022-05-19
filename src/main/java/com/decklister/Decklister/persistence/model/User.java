package com.decklister.Decklister.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(unique = true)
    private String email;

    private String password;

    private String role;
}
