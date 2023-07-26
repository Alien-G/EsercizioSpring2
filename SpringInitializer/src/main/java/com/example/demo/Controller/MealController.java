package com.example.demo.Controller;

import com.example.demo.Service.Meal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MealController extends MealControllerList {

    public MealController() {
        super();
    }

    @PostMapping("/meal")
    public void addMeal(@RequestBody Meal newMeal) {
        getMeals().add(newMeal);
    }

    @PutMapping("/meal/{name}")
    public void updateMeal(@PathVariable String name, @RequestBody Meal updatedMeal) {
        List<Meal> meals = getMeals(); // Get the meals list from the superclass.
        for (Meal meal : meals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                meal.setName(updatedMeal.getName());
                meal.setPrice(updatedMeal.getPrice());
                meal.setRating(updatedMeal.getRating());
                meal.setDescription(updatedMeal.getDescription());
                return;
            }
        }
    }

    @DeleteMapping("/meal/{name}")
    public void deleteMeal(@PathVariable String name) {
        List<Meal> meals = getMeals();
        meals.removeIf(meal -> meal.getName().equalsIgnoreCase(name));
    }

    @DeleteMapping("/meal/price/{price}")
    public void deleteMealsAbovePrice(@PathVariable double price) {
        List<Meal> meals = getMeals();
        meals.removeIf(meal -> meal.getPrice() > price);
    }

    @PutMapping("/meal/{name}/price")
    public void updateMealPrice(@PathVariable String name, @RequestBody double updatedPrice) {
        List<Meal> meals = getMeals();
        for (Meal meal : meals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                meal.setPrice(updatedPrice);
                return;
            }
        }
    }
}
