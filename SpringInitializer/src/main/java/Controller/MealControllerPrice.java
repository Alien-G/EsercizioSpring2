package Controller;

import Service.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealControllerPrice {

    private List<Meal> meals;

    public MealControllerPrice() {
        meals = new ArrayList<>();
        meals.add(new Meal("Pancakes", 9.99, 8.5, "Pancakes with Maple Syrup"));
        meals.add(new Meal("Sandwich", 6.99, 6.5, "BLT Sandwich"));
        meals.add(new Meal("Pizza", 12.99, 9.0, "Pizza with Pepperoni"));
    }

    @GetMapping("/meal/price")
    public List<Meal> getMealsByPriceRange(@RequestParam("min") double minPrice, @RequestParam("max") double maxPrice) {
        List<Meal> mealsByPrice = new ArrayList<>();
        for (Meal meal : meals) {
            if (meal.getPrice() >= minPrice && meal.getPrice() <= maxPrice) {
                mealsByPrice.add(meal);
            }
        }
        return mealsByPrice;
    }
}