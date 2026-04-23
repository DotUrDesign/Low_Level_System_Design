package model;

public class RateLimiterConfig {
    private int maxRequests;
    private long windowInSec;

    public RateLimiterConfig(int maxRequests, long windowInSec) {
        this.maxRequests = maxRequests;
        this.windowInSec = windowInSec;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public void setMaxRequests(int maxRequests) {
        this.maxRequests = maxRequests;
    }

    public long getWindowInSec() {
        return windowInSec;
    }

    public void setWindowInSec(long windowInSec) {
        this.windowInSec = windowInSec;
    }
}
