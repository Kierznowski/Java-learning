import java.io.*;

public class PlayerTest {

    public static void main(String[] args) {

        Player object = new Player("Przemek", 28, 12, 100, "male");
        String filename = "serialize.txt";

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
            System.out.println("Data before deserialization: ");
            System.out.println("name: " + object.name);
            System.out.println("age: " + object.age);
            System.out.println("b = " + object.b);
            System.out.println("points: " + object.points);
            System.out.println("gender: " + object.gender);

            object.b = 2000;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        object = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            object = (Player)in.readObject();

            in.close();
            file.close();
            System.out.println("Object has been deserialized");
            System.out.println("Data after deserialization: ");
            System.out.println("name: " + object.name);
            System.out.println("age: " + object.age);
            System.out.println("b = " + object.b);
            System.out.println("points: " + object.points);
            System.out.println("gender: " + object.gender);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
