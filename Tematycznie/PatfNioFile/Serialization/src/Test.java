import java.io.*;

public class Test {
    public static void main(String[] args) {
        Demo object = new Demo(1, "someObject");
        String fileName = "file.ser";

        //serialization
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Demo object1 = null;

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream input = new ObjectInputStream(file);

            object1 = (Demo)input.readObject();

            input.close();
            file.close();

            System.out.println("Object has been deserialized: ");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
