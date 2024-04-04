import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Grouping {
    public static void run() {

        ArrayList<Coffee> coffees = new ArrayList<>();

        coffees.add(new Coffee("Latte", 5.5f, 300));
        coffees.add(new Coffee("Americano", 3.5f, 230));
        coffees.add(new Coffee("Flat White", 4f, 230));
        coffees.add(new Coffee("Flat White", 4.5f, 230));

        Map<Float, List<Coffee>> groupingByPrice = coffees.stream()
                .collect(Collectors.groupingBy(Coffee::getPrice));
        System.out.println(groupingByPrice);

        Map<Boolean, List<Coffee>> partitionedByPrice = coffees.stream()
                .collect(Collectors.partitioningBy(coffee -> coffee.getPrice() < 4));
        System.out.println(partitionedByPrice);
    }
}
