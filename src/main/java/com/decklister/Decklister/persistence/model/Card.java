package com.decklister.Decklister.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    private String name;

    private int quantity;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Deck deck;


}
