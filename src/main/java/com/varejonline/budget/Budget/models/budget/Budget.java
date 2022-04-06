package com.varejonline.budget.Budget.models.budget;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Table(name = "Budget")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer validity;


}
