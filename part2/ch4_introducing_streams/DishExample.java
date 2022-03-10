package part2.ch4_introducing_streams;

import part2.data.Constants;
import part2.data.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DishExample {
    public static void main(String[] args) {
        // menu -> filter -> map -> limit -> collect
        List<String> threeHighCaloricDishNames = Constants.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("the three high caloric dishes: " + threeHighCaloricDishNames);
    }

}
