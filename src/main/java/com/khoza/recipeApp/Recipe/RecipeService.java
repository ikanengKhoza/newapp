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

        //Save the recipe to the database, and after this is done, the recipe will get an ID.
        recipeRepository.save(recipe);

        //Getting the ingredients of the recipe into it's own variable.
        List<Ingredients> ingredients = recipe.getIngredients();

        //Go through all of the ingredients, ensure that the recipe object is set onto it (so it knows which recipe_id to use when saving)
        for(int i = 0; i < ingredients.size(); i++)
        {
            //Get the ith ingredient from the list based on the i variable / counter.
            Ingredients ingredient = ingredients.get(i);

            //Set the recipe on the ingredients object.
            ingredient.setRecipe(recipe);

            //Save the ingredient to the ingredients table.
            ingredientsRepository.save(ingredient);
        }
    }

    public List<Ingredients> findAll() {
        return ingredientsRepository.findAll();
    }
}
