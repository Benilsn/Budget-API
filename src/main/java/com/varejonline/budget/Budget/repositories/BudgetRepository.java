package com.varejonline.budget.Budget.repositories;

import com.varejonline.budget.Budget.models.budget.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {

    Long countById(Long id);
}
