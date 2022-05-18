package com.decklister.Decklister.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;
}
