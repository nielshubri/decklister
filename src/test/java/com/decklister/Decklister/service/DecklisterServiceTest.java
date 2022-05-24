package com.decklister.Decklister.service;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Player;
import com.decklister.Decklister.persistence.model.User;
import com.decklister.Decklister.persistence.repository.PlayerRepository;
import com.decklister.Decklister.persistence.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class DecklisterServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    DecklisterService decklisterService;

    private Player createTestPlayer() {
        Card testCard = new Card("Brainstorm", 4);

        List<Card> decklist = new ArrayList<>();
        decklist.add(testCard);

        Player testPlayer = new Player("Niels", "SneakAndShow", decklist);

        return testPlayer;
    }

    @Test
    void findAllPlayers() {
        decklisterService.findAllPlayers();
        Mockito.verify(playerRepository).findAll();
    }

    @Test
    void createPlayer() {
        Player newPlayer = createTestPlayer();

        decklisterService.createPlayer(newPlayer);

        Mockito.verify(playerRepository)
                .save(
                        Mockito.argThat(
                                argument -> {
                                    Assertions.assertThat(argument).isEqualTo(newPlayer);
                                    return true;
                                }));
    }

    @Test
    void createPlayerWithExistingPlayer() {
        Player newPlayer = createTestPlayer();

        Mockito.when(playerRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(newPlayer));

        decklisterService.createPlayer(newPlayer);

        Mockito.verify(playerRepository)
                .deleteById(
                        Mockito.argThat(
                                argument -> {
                                    Assertions.assertThat(argument).isEqualTo(newPlayer.getName());
                                    return true;
                                }));

        Mockito.verify(playerRepository)
                .save(
                        Mockito.argThat(
                                argument -> {
                                    Assertions.assertThat(argument).isEqualTo(newPlayer);
                                    return true;
                                }));
    }

    @Test
    void deletePlayer() {
        assertThatThrownBy(() -> decklisterService.deletePlayer("Niels"))
                .hasMessage("Player does not exist");
    }

    @Test
    void deletePlayerWithExistingPlayer() {
        Player newPlayer = createTestPlayer();

        Mockito.when(playerRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(newPlayer));

        decklisterService.deletePlayer("Niels");

        Mockito.verify(playerRepository)
                .deleteById(
                        Mockito.argThat(
                                argument -> {
                                    Assertions.assertThat(argument).isEqualTo(newPlayer.getName());
                                    return true;
                                }));
    }

    @Test
    void createUser() {
        User newUser = new User("niels.huntebrinker@posteo.de", "password", "role");

        Mockito.when(passwordEncoder.encode(ArgumentMatchers.any())).thenReturn("dummyPassword");

        decklisterService.createUser(newUser);

        Mockito.verify(userRepository)
                .save(
                        Mockito.argThat(
                                savedUser -> {
                                    Assertions.assertThat(savedUser.getPassword()).isEqualTo("dummyPassword");
                                    Assertions.assertThat(savedUser).isEqualTo(newUser);
                                    return true;
                                }));
    }

    @Test
    void createUserWithExistingUser() {
        User newUser = new User("niels.huntebrinker@posteo.de", "password", "role");

        Mockito.when(userRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(newUser));

        Mockito.when(passwordEncoder.encode(ArgumentMatchers.any())).thenReturn("dummyPassword");

        decklisterService.createUser(newUser);

        Mockito.verify(userRepository)
                .deleteById(
                        Mockito.argThat(
                                argument -> {
                                    Assertions.assertThat(argument).isEqualTo(newUser.getEmail());
                                    return true;
                                }));

        Mockito.verify(userRepository)
                .save(
                        Mockito.argThat(
                                savedUser -> {
                                    Assertions.assertThat(savedUser.getPassword()).isEqualTo("dummyPassword");
                                    Assertions.assertThat(savedUser).isEqualTo(newUser);
                                    return true;
                                }));
    }

    @Test
    void deleteUser() {
        assertThatThrownBy(() -> decklisterService.deleteUser("niels.huntebrinker@posteo.de"))
                .hasMessage("User does not exist");
    }

    @Test
    void deleteUserWithExistingUser() {
        User newUser = new User("niels.huntebrinker@posteo.de", "password", "role");

        Mockito.when(userRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(newUser));

        decklisterService.deleteUser("niels.huntebrinker@posteo.de");

        Mockito.verify(userRepository)
                .deleteById(
                        Mockito.argThat(
                                argument -> {
                                    Assertions.assertThat(argument).isEqualTo(newUser.getEmail());
                                    return true;
                                }));
    }

    @Test
    void findAllUsers() {
        decklisterService.findAllUsers();
        Mockito.verify(userRepository).findAll();
    }
}