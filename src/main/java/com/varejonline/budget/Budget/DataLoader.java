package com.varejonline.budget.Budget;

import com.varejonline.budget.Budget.models.user.User;
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
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        User manager = new User("manager", passwordEncoder.encode("manager"), "ADMIN");
        userRepository.save(manager);

        User seller = new User("seller", passwordEncoder.encode("seller"),"USER");

        userRepository.save(seller);

    }
}
