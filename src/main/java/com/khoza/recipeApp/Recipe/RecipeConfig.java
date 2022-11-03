package com.khoza.recipeApp.Recipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateOperations;

import java.util.List;

@Configuration
public class RecipeConfig {
    @Bean
    CommandLineRunner commandLineRunner(RecipeRepository repository, IngredientsRepository repo) {

        return args -> {

                    Recipe BlackberryPie = new Recipe(
                            "Blackberry pie",
                            List.of(
                                    new Ingredients("blackberries", "600g"),
                                    new Ingredients("self-raising flour", "300g (plus extra for dusting)")),
                            "First, make the pastry. Tip both flours and the sugar into a bowl with a large pinch of salt..."
                    );

            Recipe Lasange = new Recipe(

                    "Lasange",
                    List.of(
                            new Ingredients("self-raising flour", "300g (plus extra for dusting)"),
                            new Ingredients("courgette coarsely grated", "700g (about 6)")),
                    "Heat oven to 220C/fan 200C/gas 7. Put a pan of water on to boil, then cook..."
            );

          repository.saveAll(
                  List.of(
                          BlackberryPie,
                          Lasange
                  )

          );

        };
    }
}
