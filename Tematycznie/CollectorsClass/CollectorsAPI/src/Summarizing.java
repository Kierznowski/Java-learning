import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class Summarizing {
    public static void run() {

        ArrayList<Coffee> coffees = new ArrayList<>();

        coffees.add(new Coffee("Latte", 5.5f, 300));
        coffees.add(new Coffee("Americano", 3.5f, 230));
        coffees.add(new Coffee("Flat White", 4f, 230));
        coffees.add(new Coffee("Flat White", 4.5f, 230));

        IntSummaryStatistics stats = coffees.stream()
                .collect(Collectors.summarizingInt(Coffee::getVolume));

        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
        System.out.println(stats.getCount());

        DoubleSummaryStatistics priceStats = coffees.stream()
                .collect(Collectors.summarizingDouble(Coffee::getPrice));

        System.out.println(priceStats.getMax());
        System.out.println(priceStats.getAverage());
        System.out.println(priceStats.getMin());
        System.out.println(priceStats.getSum());
        System.out.println(priceStats.getCount());
    }
}
