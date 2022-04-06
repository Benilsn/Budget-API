package com.varejonline.budget.Budget.repositories;

import com.varejonline.budget.Budget.models.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
