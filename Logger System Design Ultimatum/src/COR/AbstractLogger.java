package COR;

import Sink.LoggerSubject;

public abstract class AbstractLogger {
    public abstract void setNextLogger(AbstractLogger nextLogger);
    public abstract void logMessage(int lvlByUser, String message, LoggerSubject loggerSubject);
}
