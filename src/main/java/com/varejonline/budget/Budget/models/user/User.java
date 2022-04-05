package com.varejonline.budget.Budget.models.user;

import com.varejonline.budget.Budget.models.user.role.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name="user_name")
    @NonNull
    private String userName;

    @Column(name="password")
    @NonNull
    private String password;

    @Column(name="role")
    @NonNull
    private Role role;
}
