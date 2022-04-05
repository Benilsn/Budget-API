package com.varejonline.budget.Budget.repositories;

import com.varejonline.budget.Budget.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
