package com.khoza.recipeApp.Recipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateOperations;

import java.util.Collections;
import java.util.List;

@Configuration
public class RecipeConfig {
    @Bean
    CommandLineRunner commandLineRunner(RecipeRepository recipesRepository, IngredientsRepository ingredientsRepository) {

        return args ->
        {
            //Create the first two recipes WITHOUT ingredients.
            Recipe blackberryPie = new Recipe("Blackberry pie", "First, make the pastry. Tip both flours and the sugar into a bowl with a large pinch of salt...");
            Recipe lasagne = new Recipe("Lasange", "Heat oven to 220C/fan 200C/gas 7. Put a pan of water on to boil, then cook...");

            //Create a list of the recipes to be saved.
            List<Recipe> recipesToBeSaved = List.of(blackberryPie, lasagne);

            //Call the 'saveAll' method on the repository to save all of the recipes.
            recipesRepository.saveAll(recipesToBeSaved);

            /**
             * Now, create the individual Ingredients objects, but be sure to pass the relevant 'Recipe' object into
             * the constructor (constructor is where you use the 'new' keyword, and then put in all of the parameters
             * which you wish the object to be constructed with).
             */
            Ingredients blackberries = new Ingredients("Blackberries", "3", blackberryPie);
            Ingredients flour = new Ingredients("Self-raising Flour", "1kg", blackberryPie);

            /**
             * Notice how for these ingredients, we are instead passing 'lasagne' as the last parameter. I encourage you
             * to control + click on the 'lasagne' and see that it takes you to the reference of the variable above.
             */
            Ingredients pasta = new Ingredients("Pasta Sheets", "12", lasagne);
            Ingredients mincedMeat = new Ingredients("Minced Meat", "500g", lasagne);

            //Create a list of the ingredients to be save
            List<Ingredients> ingredientsToBeSaved = List.of(blackberries, flour, pasta, mincedMeat);

            //Call the 'saveAll' method on the repository to save all of the ingredients.
            ingredientsRepository.saveAll(ingredientsToBeSaved);
        };
    }
}
