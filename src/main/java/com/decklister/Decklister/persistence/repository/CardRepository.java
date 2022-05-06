package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card,Long> {}
