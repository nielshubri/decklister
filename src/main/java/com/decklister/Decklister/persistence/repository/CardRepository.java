package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card,Long> {
    Optional<Card> findByNameEquals(String name);
}
