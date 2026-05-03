public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();  // singleton object of logger class
        logger.info("This is an Info");
        logger.error("This is an error");
        logger.debug("This is a debug");
    }
}
