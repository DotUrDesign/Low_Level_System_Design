package model;
/*
    This is a class which will be completely individual for every user.
    userWindow
    - windowId
    - count

    windowId - this is the window within which the user requests are being hit.
    count - the no of requests inside that window for a particular user.

    Remember, every parameter or sub-parameter - is for a particular user. Nothing
    is declared global.
 */
public class UserWindow {
    private long windowId;
    private int count;

    public UserWindow(long windowId, int count) {
        this.windowId = windowId;
        this.count = count;
    }

    public long getWindowId() {
        return windowId;
    }

    public void setWindowId(long windowId) {
        this.windowId = windowId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
