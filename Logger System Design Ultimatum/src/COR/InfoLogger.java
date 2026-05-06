package COR;

import Sink.LoggerSubject;

public class InfoLogger extends AbstractLogger {
    public AbstractLogger nextLogger;
    int level;
    public InfoLogger(int level) {
        this.level = level;
    }
    @Override
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
    public void logMessage(int lvlByUser, String message, LoggerSubject loggerSubject) {
        if(this.level <= lvlByUser) {
            // display message -> but where ??
            // for this part, we need sink -- console or file
            loggerSubject.notifyAllObservers(level, message);
        }

        if(nextLogger != null) {
            nextLogger.logMessage(lvlByUser, message, loggerSubject);
        }
    }
}
