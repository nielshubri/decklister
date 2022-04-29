package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Deck;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface DeckRepository extends CrudRepository<Deck,Long> {
    Deck findByNameEquals(String name);
}
