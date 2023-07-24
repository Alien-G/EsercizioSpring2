package Controller;

import Service.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExerciseController1 {

    private List<Meal> meals;

    public ExerciseController1() {
        meals = new ArrayList<>();
        meals.add(new Meal("Pancakes", 9.99, 8.5, "Pancakes with M"));
        meals.add(new Meal("Sandwich", 6.99, 6.5, "BLT Sandwich"));
        meals.add(new Meal("Pizza", 12.99, 9.0, "Pizza with Pepperoni"));
    }

    @GetMapping("/meal/{name}")
    public Meal getMealByName(@PathVariable String name) {
        for (Meal meal : meals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                return meal;
            }
        }
        return null;
    }
}