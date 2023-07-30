package com.example.demo.Controller;

import com.example.demo.Service.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MealControllerDescription {

    private List<Meal> meals;

    public MealControllerDescription() {
        meals = new ArrayList<>();
        meals.add(new Meal("Pancakes", 9.99, 8.5, "Pancakes with Maple Syrup"));
        meals.add(new Meal("Sandwich", 6.99, 6.5, "BLT Sandwich"));
        meals.add(new Meal("Pizza", 12.99, 9.0, "Pizza with Pepperoni"));
    }

    @GetMapping("/meal/description-match/{phrase}")
    public Meal getMealByDescription(@PathVariable String phrase) {
        for (Meal meal : meals) {
            if (meal.getDescription().toLowerCase().contains(phrase.toLowerCase())) {
                return meal;
            }
        }
        return null;
    }

}