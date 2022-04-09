package com.varejonline.budget.Budget.services;

import com.varejonline.budget.Budget.exception.BudgetNotFoundException;
import com.varejonline.budget.Budget.models.budget.Budget;
import com.varejonline.budget.Budget.models.client.Client;
import com.varejonline.budget.Budget.models.product.Product;
import com.varejonline.budget.Budget.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;


    public List<Budget> getAllBudgets (){
        return (List<Budget>) budgetRepository.findAll();
    }

    public List<Product> getAllProducts(){
        var budget = (List<Budget>) budgetRepository.findAll();
        List<Product> products = new ArrayList<>();

        for (Budget b : budget){
            for (Product p : b.getProducts()){
                products.add(p);
            }
        }
        return products;
    }

    public void save(Budget budget){

        if (budget.getId() == null){
            Budget budgetToSave = new Budget(
                    budget.getValidity(),
                    new Client(
                            budget.getClient().getName(),
                            budget.getClient().getAddress()
                    ),
                    budget.getObservation()
            );
            budgetRepository.save(budgetToSave);
        }else {
            budgetRepository.save(budget);
        }
    }

    public Budget get(Long id) throws BudgetNotFoundException {
        var budget = budgetRepository.findById(id);

        if (budget.isPresent()){
            return budget.get();
        }
        throw new BudgetNotFoundException("Budget with ID: " + id + " not found!");
    }


    public void delete(Long id) throws BudgetNotFoundException {
        var count = budgetRepository.countById(id);

        if (count == null || count == 0){
            throw new BudgetNotFoundException("Could not find any budget with ID: "+ id);
        }
        budgetRepository.deleteById(id);
    }

    public void save(Budget budget, Product product){
        budget.getProducts().add(product);
        budgetRepository.save(budget);
    }


}
