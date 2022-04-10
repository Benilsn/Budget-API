package com.varejonline.budget.Budget.models.budget;

import com.varejonline.budget.Budget.models.client.Client;
import com.varejonline.budget.Budget.models.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;


@Table(name = "Budget")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer validity;

    @OneToOne(cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(cascade=CascadeType.ALL)
    @ElementCollection
    @CollectionTable(name = "products", joinColumns = @JoinColumn(name = "budget_id"))
    private Set<Product> products = new HashSet<>();

    @Column
    private Double totalValue = 0.0;

    @Column(nullable = true)
    private String observation;

    @Column
    private String timeCreated;

    @Column
    private String createdBy;

    @Column
    private String expire;

    @Column
    private Integer itensAmount;

    @Transient
    private final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Budget(Integer validity, Client client, String observation){
        this.validity = validity;
        this.client = client;
        for (Product p : products){
            totalValue += p.getTotalDiscount();
        }
        this.observation = observation;
        this.timeCreated = sdf.format(LocalDate.now());
        this.createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
        this.expire = sdf.format(LocalDate.now().plusDays(validity));
        this.itensAmount = products.size();
    }

    public void addProduct(Product product){
        this.totalValue += product.getTotalDiscount();
        products.add(product);
    }

    public void setItensAmount(){
        this.itensAmount = products.size();
    }

}
