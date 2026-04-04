package model;
/*
    This userWindow class stores the value of window and the count of the no of
    requests for a particular user.

    This is one of the value for a (key,value) pair for a hasmap.
 */
public class UserWindow {
    private long windowInSec;
    private int count;

    public UserWindow(long windowInSec, int count) {
        this.windowInSec = windowInSec;
        this.count = count;
    }

    public long getWindowInSec() {
        return windowInSec;
    }

    public void setWindowInSec(long windowInSec) {
        this.windowInSec = windowInSec;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
