package com.decklister.Decklister.service;

import com.decklister.Decklister.persistence.model.Player;
import com.decklister.Decklister.persistence.repository.PlayerRepository;
import com.decklister.Decklister.persistence.model.User;
import com.decklister.Decklister.persistence.repository.CardRepository;
import com.decklister.Decklister.persistence.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class DecklisterService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Iterable<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public Player registerPlayer(Player newPlayer) {
        if (playerRepository.findById(newPlayer.getName()).isPresent()) {
            playerRepository.deleteById(newPlayer.getName());
        }
        return playerRepository.save(newPlayer);
    }

    public void deletePlayer(String playerName) {
        if (playerRepository.findById(playerName).isPresent()) {
            playerRepository.deleteById(playerName);
        }
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            return userRepository.save(user);
        }
        else {
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);
        }
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }
}