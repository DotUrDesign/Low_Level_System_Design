package cor;

public class InfoLogger extends AbstractLogger{
    int level;
    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(int providedLvl, String message) {
        if(this.level <= providedLvl) {
            System.out.println("INFO : " + message);
        }

        if(nextLogger != null) {
            nextLogger.logMessage(providedLvl, message);
        }
    }
}
