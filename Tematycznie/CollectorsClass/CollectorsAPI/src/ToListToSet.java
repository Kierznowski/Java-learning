
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListToSet {
    public static void run() {

        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country("Poland", "Warsaw"));
        countries.add(new Country("USA", "Washington"));
        countries.add(new Country("Germany", "Berlin"));
        countries.add(new Country("Italy", "Rome"));
        countries.add(new Country("Greece", "Athene"));
        countries.add(new Country("Greece", "Athene"));

        List<String> gCountries = countries.stream()
                .filter(country -> country.name.startsWith("G"))
                .map(country -> country.name)
                .collect(Collectors.toList());

        System.out.println(gCountries);

        Set<String> countriesSet = countries.stream()
                .map(country -> country.name)
                .collect(Collectors.toSet());

        System.out.println(countriesSet);
    }



}


