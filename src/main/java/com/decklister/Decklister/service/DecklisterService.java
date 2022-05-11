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

import javax.transaction.Transactional;

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

    public Iterable<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Transactional
    public Player registerPlayer (Player newPlayer) {
        Player existingPlayer = playerRepository.findByNameEquals(newPlayer.getName());
        if (existingPlayer == null) {
            return playerRepository.save(newPlayer);
        }
        else {
            existingPlayer.setDeck(newPlayer.getDeck());
            return playerRepository.save(newPlayer);
        }
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
