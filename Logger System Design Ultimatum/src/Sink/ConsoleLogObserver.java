package Sink;

public class ConsoleLogObserver implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Written in console : " + message);
    }
}

