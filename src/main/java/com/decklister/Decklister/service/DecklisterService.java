package com.decklister.Decklister.service;

import com.decklister.Decklister.persistence.model.Player;
import com.decklister.Decklister.persistence.repository.PlayerRepository;
import com.decklister.Decklister.security.SecurityConfig;
import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.model.User;
import com.decklister.Decklister.persistence.repository.CardRepository;
import com.decklister.Decklister.persistence.repository.DeckRepository;
import com.decklister.Decklister.persistence.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class DecklisterService {
    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SecurityConfig securityConfig;

    public Iterable<Deck> findAllDecks() {
        return deckRepository.findAll();
    }

    public Deck createDeck (Deck newDeck) {
        if (newDeck.getPlayer() == null) {
            throw new IllegalArgumentException("a deck must have a player");
        }
        if (newDeck.getCards() == null) {
            throw new IllegalArgumentException("a deck must have cards");
        }
        return deckRepository.save(newDeck);
    }

    public void deleteDeck (String deckName) {
        Deck deckToDelete = deckRepository.findByNameEquals(deckName);
        deckRepository.delete(deckToDelete);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser (User user)  {
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
}
