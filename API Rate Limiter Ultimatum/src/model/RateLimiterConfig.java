package model;

import enums.RateLimiterType;

public class RateLimiterConfig {
    private int maxRequest;
    private long windowInSec;

    public RateLimiterConfig(int maxRequest, long windowInSec) {
        this.maxRequest = maxRequest;
        this.windowInSec = windowInSec;
    }

    public int getMaxRequest() {
        return maxRequest;
    }

    public void setMaxRequest(int maxRequest) {
        this.maxRequest = maxRequest;
    }

    public long getWindowInSec() {
        return windowInSec;
    }

    public void setWindowInSec(long windowInSec) {
        this.windowInSec = windowInSec;
    }
}
