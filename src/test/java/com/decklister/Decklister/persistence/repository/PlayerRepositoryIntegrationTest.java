package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PlayerRepositoryIntegrationTest {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void playerSave() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);
        Deck newDeck = new Deck("SneakAndShow", decklist);

        Player newPlayer = new Player("Niels", newDeck);

        playerRepository.save(newPlayer);

        assertThat(entityManager.find(Player.class,newPlayer.getId())).isEqualTo(newPlayer);
    }

    @Test
    void playerUpdate() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);
        Deck newDeck = new Deck("SneakAndShow", decklist);

        Player newPlayer = new Player("Niels", newDeck);

        entityManager.persist(newPlayer);

        newCard.setQuantity(newCard.getQuantity() + 1);
        newDeck.setName(newDeck.getName() + "test");
        newPlayer.setName(newPlayer.getName() + "test");

        playerRepository.save(newPlayer);

        assertThat(entityManager.find(Deck.class,newDeck.getId())).isEqualTo(newDeck);
    }

    @Test
    void playerDelete() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);
        Deck newDeck = new Deck("SneakAndShow", decklist);

        Player newPlayer = new Player("Niels", newDeck);

        entityManager.persist(newPlayer);

        playerRepository.delete(newPlayer);

        assertThat(entityManager.find(Player.class,newPlayer.getId())).isEqualTo(null);
        assertThat(entityManager.find(Deck.class,newDeck.getId())).isEqualTo(null);
        assertThat(entityManager.find(Card.class,newCard.getId())).isEqualTo(null);
    }

    @Test
    void playerFindByNameEquals() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);
        Deck newDeck = new Deck("SneakAndShow", decklist);

        Player newPlayer = new Player("Niels", newDeck);

        entityManager.persist(newPlayer);

        Player retrievedPlayer = playerRepository.findByNameEquals(newPlayer.getName());

        assertThat(retrievedPlayer).isEqualTo(newPlayer);
    }
}