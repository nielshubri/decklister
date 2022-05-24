package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Player;
import com.decklister.Decklister.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryIntegrationTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void save() {
        User newUser = new User("niels.huntebrinker@posteo.de", "password", "role");

        newUser = userRepository.save(newUser);

        assertThat(entityManager.find(User.class,newUser.getEmail()).equals(newUser));
    }

    @Test
    void deleteById() {
        User newUser = new User("niels.huntebrinker@posteo.de", "password", "role");

        entityManager.persist(newUser);

        userRepository.deleteById(newUser.getEmail());

        assertThat(entityManager.find(User.class, newUser.getEmail()) == null);
    }

    @Test
    void findById() {
        User newUser = new User("niels.huntebrinker@posteo.de", "password", "role");

        entityManager.persist(newUser);

        Optional<User> retrievedUser = userRepository.findById(newUser.getEmail());

        assertThat(entityManager.find(User.class,newUser.getEmail())).isEqualTo(retrievedUser.get());
    }

    @Test
    void findAll() {
        User newUser = new User("niels.huntebrinker@posteo.de", "password", "role");

        entityManager.persist(newUser);

        Iterable<User> retrievedUser = userRepository.findAll();

        assertThat(entityManager.find(User.class,newUser.getEmail())).isEqualTo(retrievedUser.iterator().next());
    }

}