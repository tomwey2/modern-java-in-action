package part2.ch6_collecting_data_with_streams;

import part2.data.Constants;
import part2.data.Dish;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Grouping {
    public enum CaloricLevel { DIET, NORMAL, FAT }

    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> dishesByType = Constants.menu.stream()
                .collect(groupingBy(Dish::getType));

        System.out.println("dishes by type:");
        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Constants.menu.stream()
                .collect(
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })
                );

        System.out.println("dishes by caloric level:");
        System.out.println(dishesByCaloricLevel);
    }
}
