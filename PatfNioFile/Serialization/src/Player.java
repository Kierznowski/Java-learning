import java.io.Serializable;

public class Player implements Serializable {

    String name;
    int age;
    transient int b;
    int points;
    transient final String gender;

    public Player(String name, int age, int b, int points, String gender) {
        this.name = name;
        this.age = age;
        this.b = b;
        this.points = points;
        this.gender = gender;
    }
}
