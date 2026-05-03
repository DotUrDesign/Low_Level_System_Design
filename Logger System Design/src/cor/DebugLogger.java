package cor;

public class DebugLogger extends AbstractLogger{
    int level;
    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(int providedLvl, String message) {
        if(this.level <= providedLvl) {
            System.out.println("DEBUG : " + message);
        }

        if(nextLogger != null) {
            nextLogger.logMessage(providedLvl, message);
        }
    }
}
