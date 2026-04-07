package model;

import java.util.ArrayDeque;
import java.util.Deque;

public class UserLog {
    private Deque<Long> timestamps = new ArrayDeque<>();
    public UserLog(Deque<Long> timestamps) {
        this.timestamps = timestamps;
    }

    public Deque<Long> getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Deque<Long> timestamps) {
        this.timestamps = timestamps;
    }
}
