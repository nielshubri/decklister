package com.decklister.Decklister.service;

import com.decklister.Decklister.config.SecurityConfig;
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
    private SecurityConfig securityConfig;

    public Iterable<Deck> findAllDecks() {
        return deckRepository.findAll();
    }

    public Deck createDeck (Deck newDeck) {
        return deckRepository.save(newDeck);
    }

    public Iterable<Card> findAllCards() {
        return cardRepository.findAll();
    }

    public void deleteDeck (String deckName) {
        Deck deckToDelete = deckRepository.findByNameEquals(deckName);
        deckRepository.delete(deckToDelete);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser (User user)  {
        User newUser = new User();
        newUser = user;
        newUser.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        return userRepository.save(newUser);
    }
}
