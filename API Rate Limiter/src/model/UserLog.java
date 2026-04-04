package model;

import java.util.ArrayDeque;
import java.util.Deque;

public class UserLog {
    /*
        for a particular user, you have to store multiple timestamps.
        pushing and poping the timestamps will be done along the way.
        Best data structure => Deque
     */
    private Deque<Long> timestamps = new ArrayDeque<>();
    public UserLog(Deque<Long> timestamps) {
        this.timestamps = timestamps;
    }
    public Deque<Long> getTimestamps() {
        return timestamps;
    }
}
