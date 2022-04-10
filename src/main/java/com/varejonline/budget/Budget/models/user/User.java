package com.varejonline.budget.Budget.models.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer userId;

    @Column(name="username")
    @NonNull
    private String username;

    @Column(name="password")
    @NonNull
    private String password;

    @Column(name="role")
    @NonNull
    private SimpleGrantedAuthority role;

    public User(String username, String password, SimpleGrantedAuthority role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
