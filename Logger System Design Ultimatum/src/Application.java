/*
    Application --> Logger --> Info/Debug/Error --> Sink(Console/File)

    User only selects the type of logger he/she wants -
    1. info
    2. debug
    3. error

    other than this, everything is configured by the backend team

 */

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
//        logger.info("This is an info");
        logger.debug("This is a debug");
//        logger.error("This is an error");
    }
}
