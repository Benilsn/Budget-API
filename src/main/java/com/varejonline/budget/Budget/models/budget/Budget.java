package com.varejonline.budget.Budget.models.budget;

import com.varejonline.budget.Budget.models.client.Client;
import com.varejonline.budget.Budget.models.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "Budget")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer validity;

    @OneToOne(cascade = CascadeType.ALL)
    private Client client;

    @ElementCollection
    @CollectionTable(name = "products", joinColumns = @JoinColumn(name = "budget_id"))
    private Set<Product> products = new HashSet<>();

    public Budget(Integer validity, Client client){
        this.validity = validity;
        this.client = client;
    }

}
