package com.decklister.Decklister.persistence.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Player {

    @Id
    private String name;

    private String deckname;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Card> cards;

    public Player () {
    }

    public Player (String name, String deckname, List<Card> decklist) {
        this.name = name;
        this.deckname = deckname;

    }
}
