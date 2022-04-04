package com.varejonline.budget.Budget.models.users;

import com.varejonline.budget.Budget.models.users.role.Role;
import javax.persistence.Entity;

@Entity
public class Seller extends User {

    private Role role;

}
