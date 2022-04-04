package com.varejonline.budget.Budget.models.users;

import lombok.Data;

@Data
public abstract class User {

    private String login;
    private String password;

}
