package com.varejonline.budget.Budget.services;

import com.varejonline.budget.Budget.exception.BudgetNotFoundException;
import com.varejonline.budget.Budget.models.budget.Budget;
import com.varejonline.budget.Budget.models.client.Client;
import com.varejonline.budget.Budget.models.product.Product;
import com.varejonline.budget.Budget.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;


    public List<Budget> getAllBudgets() {
        return (List<Budget>) budgetRepository.findAll();
    }

    public List<Product> getAllProducts(Long id) throws BudgetNotFoundException {

        var budget = budgetRepository.findById(id);

        if (budget.isPresent()) {

            List<Product> products = new ArrayList<>();
            budget.get().getProducts().stream().forEach(products::add);
            return products;
        }
        throw new BudgetNotFoundException("Budget with ID: " + id + " not found!");
    }

    public void save(Budget budget) {

        if (budget.getId() == null) {
            Budget budgetToSave = new Budget(
                    budget.getValidity(),
                    new Client(
                            budget.getClient().getName(),
                            budget.getClient().getAddress()
                    ),
                    budget.getObservation(), new HashSet<Product>()
            );
            budgetRepository.save(budgetToSave);
        } else {
            budgetRepository.save(budget);
        }
    }

    public Budget get(Long id) throws BudgetNotFoundException {
        var budget = budgetRepository.findById(id);

        if (budget.isPresent()) {
            return budget.get();
        }
        throw new BudgetNotFoundException("Budget with ID: " + id + " not found!");
    }


    public void delete(Long id) throws BudgetNotFoundException {
        var count = budgetRepository.countById(id);

        if (count == null || count == 0) {
            throw new BudgetNotFoundException("Could not find any budget with ID: " + id);
        }
        budgetRepository.deleteById(id);
    }

    public void saveProductToBudget(Budget budget, Product product) throws BudgetNotFoundException {
        var productToSave = new Product();
        productToSave.setName(product.getName());
        productToSave.setAmount(product.getAmount());
        productToSave.setUnitaryValue(product.getUnitaryValue());
        productToSave.setPercentageDiscount(product.getPercentageDiscount());
        productToSave.setTotalDiscount();
        budget.addProduct(productToSave);
        budget.setItensAmount();
        budgetRepository.save(budget);
    }

}
