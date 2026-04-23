package model;

public class UserWindow {
    public long windowId;
    public int noOfReq;

    public UserWindow(long windowId, int noOfReq) {
        this.windowId = windowId;
        this.noOfReq = noOfReq;
    }

    public long getWindowId() {
        return windowId;
    }

    public void setWindowId(long windowId) {
        this.windowId = windowId;
    }

    public int getNoOfReq() {
        return noOfReq;
    }

    public void setNoOfReq(int noOfReq) {
        this.noOfReq = noOfReq;
    }
}
