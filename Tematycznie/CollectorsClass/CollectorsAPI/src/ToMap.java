import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMap {

    public static void run(){
        ArrayList<Coffee> coffees = new ArrayList<>();

        coffees.add(new Coffee("Latte", 5.5f, 300));
        coffees.add(new Coffee("Americano", 3.5f, 230));
        coffees.add(new Coffee("Flat White", 4f, 230));
        coffees.add(new Coffee("Flat White", 4.5f, 230));

        Map<String, Float> prices = coffees.stream()
                .filter(coffee -> coffee.getPrice() < 5f)
                .collect(Collectors.toMap(Coffee::getName, Coffee::getPrice, (oldValue, newValue) -> newValue));

        System.out.println(prices);
    }


}
