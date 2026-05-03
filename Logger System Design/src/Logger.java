import cor.AbstractLogger;
import cor.LogManager;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

/*
    Logger class -
    1. singleton object
    2. reflection API
    3. Cloneable interface
    4. serializable interface

 */
public class Logger implements Cloneable, Serializable {
    private volatile static Logger logger;
    private volatile static AbstractLogger chainLogger;
    private static ReentrantLock lock = new ReentrantLock();

    // singleton object
    private Logger() {
        if(logger != null) {
            throw new IllegalStateException("Logger has already been created");
        }
    }
    public static Logger getLogger() {
        if(logger == null) {
            lock.lock();
            if(logger == null) {
                logger = new Logger();
                chainLogger = LogManager.getLogChain();
            }
        }

        return logger;
    }

    // This method is to handle the cloneable interface.
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    // this method is to handle the serializable interface
    public Object readResolve() {
        return logger;
    }

    public void info(String message) {
        chainLogger.logMessage(1, message);
    }

    public void error(String message) {
        chainLogger.logMessage(2, message);
    }

    public void debug(String message) {
        chainLogger.logMessage(3, message);
    }
}
