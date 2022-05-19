package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DeckRepositoryIntegrationTest {

    @Autowired
    DeckRepository deckRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void deckSave() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);
        Deck newDeck = new Deck("SneakAndShow", decklist);

        deckRepository.save(newDeck);

        assertThat(entityManager.find(Deck.class,newDeck.getId())).isEqualTo(newDeck);
    }

    @Test
    void deckUpdate() {
        Card newCard1 = new Card("Brainstorm", 4);
        Card newCard2 = new Card("Preordain", 2);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard1);
        decklist.add(newCard2);

        Deck newDeck = new Deck("SneakAndShow", decklist);

        entityManager.persist(newDeck);

        //change deck name
        newDeck.setName("Storm");

        //change 1 card from decklist
        newCard1.setQuantity(3);

        //add 1 card to decklist
        Card newCard3 = new Card("Ponder", 3);
        newDeck.getCards().add(newCard3);

        //remove 1 card from decklist
        newDeck.getCards().remove(newCard2);

        deckRepository.save(newDeck);

        assertThat(entityManager.find(Deck.class,newDeck.getId())).isEqualTo(newDeck);
    }

    @Test
    void deckDelete() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);

        Deck newDeck = new Deck("SneakAndShow", decklist);

        entityManager.persist(newDeck);

        deckRepository.delete(newDeck);

        assertThat(entityManager.find(Deck.class,newDeck.getId())).isEqualTo(null);
        assertThat(entityManager.find(Card.class,newCard.getId())).isEqualTo(null);
    }
}