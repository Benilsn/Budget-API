package com.varejonline.budget.Budget.models.product;

import com.varejonline.budget.Budget.models.budget.Budget;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Product")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Double unitaryValue;

    @Column(nullable = false)
    private Double percentageDiscount;

    @Column
    private Double totalDiscount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "budget_id")
    private Budget budget;


    public Product(String name, Integer amount, Double unitaryValue, Double percentageDiscount){
        this.name = name;
        this.amount = amount;
        this.unitaryValue = unitaryValue;
        this.percentageDiscount = percentageDiscount;
    }

    public void setTotalDiscount(){
        var discount = ((amount * unitaryValue) * percentageDiscount) /100;
        this.totalDiscount = (amount * unitaryValue) - discount;
    }


}