package Controller;

import Service.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class ExerciseController4 {

    private List<Meal> meals;

    public ExerciseController4() {
        meals = new ArrayList<>();
        meals.add(new Meal("Pancakes", 9.99, 8.5, "Pancakes with Maple Syrup"));
        meals.add(new Meal("Sandwich", 6.99, 6.5, "BLT Sandwich"));
        meals.add(new Meal("Pizza", 12.99, 9.0, "Pizza with Pepperoni"));
    }

    @GetMapping("/meals")
    public List<Meal> getMeals() {
        return meals;
    }
}