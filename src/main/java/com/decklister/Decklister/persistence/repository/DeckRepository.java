package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Deck;
import org.springframework.data.repository.CrudRepository;


public interface DeckRepository extends CrudRepository<Deck,Long> {
}
