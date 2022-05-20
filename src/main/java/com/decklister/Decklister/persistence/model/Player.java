package com.decklister.Decklister.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Player {

    @Id
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Deck deck;

    public Player () {
    }

    public Player (String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }
}
