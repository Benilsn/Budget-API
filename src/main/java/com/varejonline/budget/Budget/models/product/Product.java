package com.varejonline.budget.Budget.models.product;

import com.varejonline.budget.Budget.models.budget.Budget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "prod_name", nullable = false)
    private String name;

    @Column(name = "prod_amount", nullable = false)
    private Integer amount;

    @Column(name = "unitaryValue", nullable = false)
    private Double unitaryValue;

    @Column(name = "percentageDiscount", nullable = false)
    private Double percentageDiscount;

    @Column(name = "totalDiscount", nullable = false)
    private Double totalDiscount;


    public Product(String name, Integer amount, Double unitaryValue, Double percentageDiscount, Double totalDiscount){
        this.name = name;
        this.amount = amount;
        this.unitaryValue = unitaryValue;
        this.percentageDiscount = percentageDiscount;
        this.totalDiscount = totalDiscount;
    }


}
