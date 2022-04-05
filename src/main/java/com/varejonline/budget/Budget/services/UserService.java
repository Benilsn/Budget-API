package com.varejonline.budget.Budget.services;

import com.varejonline.budget.Budget.models.user.User;
import com.varejonline.budget.Budget.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
