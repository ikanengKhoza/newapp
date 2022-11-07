package com.khoza.recipeApp.Recipe;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Ingredients implements Serializable {

    @Id
    private String name;
    private String quantity;

    @ManyToOne()
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Ingredients(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredients() {
    }

    public Ingredients(String name, String quantity, Recipe recipe) {
        this.name = name;
        this.quantity = quantity;
        this.recipe = recipe;
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
