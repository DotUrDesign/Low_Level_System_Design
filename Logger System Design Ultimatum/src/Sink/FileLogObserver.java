package Sink;

public class FileLogObserver implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Written in file : " + message);
    }
}
