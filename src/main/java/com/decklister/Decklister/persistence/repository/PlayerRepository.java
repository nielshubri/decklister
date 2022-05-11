package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player,Long> {
    Player findByNameEquals(String name);
}
