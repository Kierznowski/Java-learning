import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {

    public static void run() {

        List<String> professions = new ArrayList<>();

        professions.add("Lekarz");
        professions.add("Prawnik");
        professions.add("Kierowca");
        professions.add("Programista");

        String zawody = professions.stream()
                .collect(Collectors.joining(", ", "Zawody: ", "."));

        System.out.println(zawody);
    }
}
