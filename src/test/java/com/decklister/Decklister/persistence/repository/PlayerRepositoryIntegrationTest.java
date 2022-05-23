package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PlayerRepositoryIntegrationTest {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void save() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);

        Player newPlayer = new Player("Niels", "SneakAndShow", decklist);

        newPlayer = playerRepository.save(newPlayer);

        assertThat(entityManager.find(Player.class,newPlayer.getName())).isEqualTo(newPlayer);
    }

    @Test
    void deleteById() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);

        Player newPlayer = new Player("Niels", "SneakAndShow", decklist);

        entityManager.persist(newPlayer);

        playerRepository.deleteById(newPlayer.getName());

        assertThat(entityManager.find(Player.class,newPlayer.getName())).isEqualTo(null);
        assertThat(entityManager.find(Card.class,newCard.getId())).isEqualTo(null);
    }

    @Test
    void findById() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);

        Player newPlayer = new Player("Niels", "SneakAndShow", decklist);

        entityManager.persist(newPlayer);

        Optional<Player> retrievedPlayer = playerRepository.findById(newPlayer.getName());

        assertThat(entityManager.find(Player.class,newPlayer.getName())).isEqualTo(retrievedPlayer.get());
    }

    @Test
    void findAll() {
        Card newCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(newCard);

        Player newPlayer = new Player("Niels", "SneakAndShow", decklist);

        entityManager.persist(newPlayer);

        Iterable<Player> retrievedPlayer = playerRepository.findAll();

        assertThat(entityManager.find(Player.class,newPlayer.getName())).isEqualTo(retrievedPlayer.iterator().next());
    }
}