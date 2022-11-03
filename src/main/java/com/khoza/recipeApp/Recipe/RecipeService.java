package com.khoza.recipeApp.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientsRepository ingredientsRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<Recipe> getRecipe() {
        return recipeRepository.findAll();
    }
    public List<Ingredients> getIngredients() {return ingredientsRepository.findAll();}


    public void save(Recipe recipe) {
    }

    public List<Ingredients> findAll() {
        return ingredientsRepository.findAll();
    }
}
