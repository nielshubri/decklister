package com.decklister.Decklister.persistence.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<Card> cards;

    public Deck () {
    }

    public Deck (String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }
}
