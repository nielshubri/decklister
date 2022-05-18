package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player,Long> {
    Player findByNameEquals(String name);
}
