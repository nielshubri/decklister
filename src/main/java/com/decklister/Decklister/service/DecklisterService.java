package com.decklister.Decklister.service;

import com.decklister.Decklister.Controller.InvalidRequestException;
import com.decklister.Decklister.persistence.model.Player;
import com.decklister.Decklister.persistence.repository.PlayerRepository;
import com.decklister.Decklister.persistence.model.User;
import com.decklister.Decklister.persistence.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class DecklisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Player createPlayer(Player newPlayer) {
        if (playerRepository.findById(newPlayer.getName()).isPresent()) {
            playerRepository.deleteById(newPlayer.getName());
        }
        return playerRepository.save(newPlayer);
    }

    public void deletePlayer(String playerName) {
        if (playerRepository.findById(playerName).isPresent()) {
            playerRepository.deleteById(playerName);
        }
        else {
            throw new InvalidRequestException("Player does not exist");
        }
    }

    public Iterable<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public User createUser(User newUser) {
        if (userRepository.findById(newUser.getEmail()).isPresent()) {
            userRepository.deleteById(newUser.getEmail());
        }
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    public void deleteUser(String email) {
        if (userRepository.findById(email).isPresent()) {
            userRepository.deleteById(email);
        }
        else {
            throw new InvalidRequestException("User does not exist");
        }
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }
}