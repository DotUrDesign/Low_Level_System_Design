package model;

import java.util.Deque;

public class UserLog {
    public Deque<Long> timestamps;

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
