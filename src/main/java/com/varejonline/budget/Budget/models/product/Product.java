package com.varejonline.budget.Budget.models.product;

import com.varejonline.budget.Budget.models.budget.Budget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Product")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer amount;

    @Column
    private Double unitaryValue;

    @Column
    private Double percentageDiscount;

    @Column
    private Double totalDiscount;


    public Product(String name, Integer amount, Double unitaryValue, Double percentageDiscount, Double totalDiscount){
        this.name = name;
        this.amount = amount;
        this.unitaryValue = unitaryValue;
        this.percentageDiscount = percentageDiscount;
        this.totalDiscount = totalDiscount;
    }


}