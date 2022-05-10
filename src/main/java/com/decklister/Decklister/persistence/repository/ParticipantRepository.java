package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant,Long> {}
