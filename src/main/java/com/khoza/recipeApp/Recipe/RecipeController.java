package com.khoza.recipeApp.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getRecipe() {

        return recipeService.getRecipe();
    }

    @PostMapping
    public String saveRecipe(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return "save...";
    }
}
