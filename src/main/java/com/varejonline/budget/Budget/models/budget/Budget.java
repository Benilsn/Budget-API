package com.varejonline.budget.Budget.models.budget;

import com.varejonline.budget.Budget.models.client.Client;
import com.varejonline.budget.Budget.models.product.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Table(name = "Budget")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "validity", nullable = false)
    private Integer validity;

    @OneToOne
    private Client client;

    @OneToMany
    private List<Product> products;

}
