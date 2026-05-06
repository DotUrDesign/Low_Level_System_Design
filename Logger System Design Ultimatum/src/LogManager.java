import COR.AbstractLogger;
import COR.DebugLogger;
import COR.ErrorLogger;
import COR.InfoLogger;
import Sink.ConsoleLogObserver;
import Sink.FileLogObserver;
import Sink.LoggerSubject;

public class LogManager {
    public static AbstractLogger getChainOfLogger() {
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger debugLogger = new DebugLogger(2);
        AbstractLogger errorLogger = new ErrorLogger(3);

        // creating the chain of loggers
        // infoLogger -> debugLogger -> errorLogger
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        return infoLogger;   // returning the head of the chain of loggers.
    }

    public static LoggerSubject addObservers() {
        LoggerSubject loggerSubject = new LoggerSubject();
        ConsoleLogObserver consoleLogObserver = new ConsoleLogObserver();
        loggerSubject.addObserver(1, consoleLogObserver);
        loggerSubject.addObserver(2, consoleLogObserver);
        loggerSubject.addObserver(3, consoleLogObserver);
        FileLogObserver fileLogObserver = new FileLogObserver();
        loggerSubject.addObserver(2, fileLogObserver);

        return loggerSubject;
    }
}
