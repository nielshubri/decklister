package com.decklister.Decklister.service;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.model.Player;
import com.decklister.Decklister.persistence.repository.CardRepository;
import com.decklister.Decklister.persistence.repository.DeckRepository;
import com.decklister.Decklister.persistence.repository.PlayerRepository;
import com.decklister.Decklister.persistence.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DecklisterServiceTest {

    @Mock private DeckRepository deckRepository;

    @Mock private CardRepository cardRepository;

    @Mock private UserRepository userRepository;

    @Mock private PlayerRepository playerRepository;

    @Mock private PasswordEncoder passwordEncoder;

    @InjectMocks private DecklisterService decklisterService;

    @Test
    void findAllPlayers() {
    }

    @Test
    void registerPlayerPlayerNotFound() {

        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();

        card1.setName("Brainstorm");
        card1.setQuantity(4);

        card2.setName("Ponder");
        card2.setQuantity(4);

        card3.setName("Preordain");
        card3.setQuantity(4);

        Deck deck1 = new Deck();

        deck1.setName("SneakAndShow");
        deck1.setCards(List.of(card1,card2,card3));

        Player player1 = new Player();
        player1.setName("Niels");
        player1.setDeck(deck1);

        when(playerRepository.findByNameEquals(any())).thenReturn(null);

        Player result = decklisterService.registerPlayer(player1);

        Mockito.verify(playerRepository).save(Mockito.argThat(argument -> {
            Assertions.assertThat(argument.getName()).isEqualTo(player1.getName());
            Assertions.assertThat(argument.getDeck()).isEqualTo(player1.getDeck());
            return true;
        }));
    }

    @Test
    void registerPlayerPlayerFound() {
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();

        card1.setId(1);
        card1.setName("Brainstorm");
        card1.setQuantity(4);

        card2.setId(2);
        card2.setName("Ponder");
        card2.setQuantity(4);

        card3.setId(3);
        card3.setName("Preordain");
        card3.setQuantity(4);

        Deck deck1 = new Deck();

        deck1.setId(1);
        deck1.setName("SneakAndShow");
        deck1.setCards(List.of(card1,card2,card3));

        Player player1 = new Player();
        player1.setId(1);
        player1.setName("Niels");
        player1.setDeck(deck1);
    }

    @Test
    void createUser() {
    }

    @Test
    void deleteDeck() {
    }

    @Test
    void findAllUsers() {
    }
}