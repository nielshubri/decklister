package com.decklister.Decklister.persistence.repository;

import com.decklister.Decklister.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail (String email);
}
