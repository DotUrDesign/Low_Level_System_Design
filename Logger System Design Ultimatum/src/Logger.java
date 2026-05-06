/*
    This logger class takes care of 3 important things while creating a logger object
    1. singleton DP
    2. cloneable interface
    3. serializable interface

    This logger has 3 functions -
    1. creating a logger object and providing it to the user
    2. COR(Chain of responsibility) for the categories
        Info -> Debug -> Error
    3. adding the observers and creating the sink
 */

import COR.AbstractLogger;
import Sink.LoggerSubject;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class Logger implements Cloneable, Serializable {
    private volatile static Logger logger = null;
    private static ReentrantLock lock = new ReentrantLock();
    private volatile static AbstractLogger chainOfLogger = null;
    private volatile static LoggerSubject loggerSubject = null;
    public Logger() {
        if(logger != null) {
            throw new IllegalStateException("Logger object already created.");
        }
    }
    public static Logger getLogger() {
        if(logger == null) {
            lock.lock();
            if(logger == null) {
                logger = new Logger();
                chainOfLogger = LogManager.getChainOfLogger();
                loggerSubject = LogManager.addObservers();
            }
        }

        return logger;
    }

    // cloneable interface
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    // serializable interface
    public Object readResolve() {
        return logger;
    }

    public void info(String message) {
        chainOfLogger.logMessage(1, " INFO : " + message, loggerSubject);
    }
    public void debug(String message) {
        chainOfLogger.logMessage(2, " DEBUG : " + message, loggerSubject);
    }
    public void error(String message) {
        chainOfLogger.logMessage(3, " ERROR : " + message, loggerSubject);
    }
}
