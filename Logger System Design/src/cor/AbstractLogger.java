package cor;

public abstract class AbstractLogger {
    AbstractLogger nextLogger = null;
    public abstract void setNextLogger(AbstractLogger nextLogger);

    public abstract void logMessage(int level, String message);
}
