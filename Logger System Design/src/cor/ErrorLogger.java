package cor;

public class ErrorLogger extends AbstractLogger{
    int level;
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(int providedLvl, String message) {
        if(this.level <= providedLvl) {
            System.out.println("ERROR : " + message);
        }

        if(nextLogger != null) {
            nextLogger.logMessage(providedLvl, message);
        }
    }
}
