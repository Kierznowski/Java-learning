import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class HelloWorld {
    private static final Logger logger = LoggerFactory.getLogger("Hello");

    public static void  main(String[] args) {

        String information = "Hello friend";

        logger.info("Info message: {}", information);
        logger.warn("Its warning");
        logger.debug("Program do something");
        logger.trace("Something is initialized");
        logger.error("Something failed");

        Marker fatal = MarkerFactory.getMarker("FATAL");

        logger.error(fatal, "This is fatal error. We are not resist this :(");


        

    }
}