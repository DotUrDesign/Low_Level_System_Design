package Sink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerSubject {
    private Map<Integer, List<LogObserver>> logObservers = new HashMap<>();
    public void addObserver(int level, LogObserver logObserver) {
        List<LogObserver> logObserverList = new ArrayList<>();
        logObserverList.add(logObserver);
        logObservers.put(level, logObserverList);
    }
    public void removeObserver(int level, LogObserver logObserver) {
        List<LogObserver> logObserverList = logObservers.getOrDefault(level, null);
        if(logObserverList == null) {
            return;
        }
        logObserverList.remove(logObserver);
        logObservers.put(level, logObserverList);
    }

    public void notifyAllObservers(int level, String message) {
        List<LogObserver> logObserverList = logObservers.getOrDefault(level, null);
        if(logObserverList == null) {
            System.out.println("No sink present to write the logs");
        }
        for(LogObserver logObserver : logObserverList) {
            logObserver.log(message);
        }
    }
}
