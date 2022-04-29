package com.decklister.Decklister.persistence.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(exclude="cards")
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    private String name;

    @OneToMany(mappedBy = "deck", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Card> cards = new HashSet<>();
}
