package com.khoza.recipeApp.Recipe;


import jdk.jfr.DataAmount;

import javax.persistence.*;
import javax.transaction.Transactional;
@Entity
@Table

public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String name;
    private String quantity;

    @ManyToOne
    private Recipe recipe;
    public Ingredients(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredients() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
