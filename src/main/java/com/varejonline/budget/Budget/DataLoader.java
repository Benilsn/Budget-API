package com.varejonline.budget.Budget;

import com.varejonline.budget.Budget.models.budget.Budget;
import com.varejonline.budget.Budget.models.client.Client;
import com.varejonline.budget.Budget.models.product.Product;
import com.varejonline.budget.Budget.models.user.User;
import com.varejonline.budget.Budget.repositories.BudgetRepository;
import com.varejonline.budget.Budget.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        Budget budget = new Budget(21, new Client("joao", "rua wtf"),new Product(
                "TV",
                13,
                12.54,
                3.2,
                44,5
        ));

        User manager = new User("manager", passwordEncoder.encode("manager"), "ADMIN");
        userRepository.save(manager);

        User seller = new User("seller", passwordEncoder.encode("seller"),"USER");

        userRepository.save(seller);

    }
}
