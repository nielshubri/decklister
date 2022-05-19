package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class CardRepositoryIntegrationTest {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void cardSave() {
        Card newCard = new Card("Brainstorm", 4);

        cardRepository.save(newCard);

        assertThat(entityManager.find(Card.class,newCard.getId())).isEqualTo(newCard);
    }

    @Test
    void cardUpdate() {
        Card newCard = new Card("Brainstorm", 4);

        entityManager.persist(newCard);

        newCard.setQuantity(3);

        cardRepository.save(newCard);

        assertThat(entityManager.find(Card.class,newCard.getId())).isEqualTo(newCard);
    }

    @Test
    void cardDelete() {
        Card newCard = new Card("Brainstorm", 4);

        entityManager.persist(newCard);

        cardRepository.delete(newCard);

        assertThat(entityManager.find(Card.class,newCard.getId())).isEqualTo(null);
    }
}