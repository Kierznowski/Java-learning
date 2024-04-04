import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Numbers {

    public static void run() {

        ArrayList<Coffee> coffees = new ArrayList<>();

        coffees.add(new Coffee("Latte", 5.5f, 300));
        coffees.add(new Coffee("Americano", 3.5f, 230));
        coffees.add(new Coffee("Flat White", 4f, 230));
        coffees.add(new Coffee("Flat White", 4.5f, 230));

        Double avgVolume = coffees.stream()
                .collect(Collectors.averagingInt(Coffee::getVolume));
        System.out.println(avgVolume);

        Double summPrice = coffees.stream()
                .collect(Collectors.summingDouble(Coffee::getPrice));
        System.out.println(summPrice);

        Long countData = coffees.stream()
                .collect(Collectors.counting());
        System.out.println(countData);

        Optional<Float> minPrice = coffees.stream()
                .map(Coffee::getPrice)
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(minPrice.get());
    }
}
