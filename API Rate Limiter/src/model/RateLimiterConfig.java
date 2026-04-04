package model;

public class RateLimiterConfig {
    private int maxRequests;
    private int windowInSeconds;

    public RateLimiterConfig(int maxRequests, int windowInSeconds) {
        this.maxRequests = maxRequests;
        this.windowInSeconds = windowInSeconds;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public int getWindowInSeconds() {
        return windowInSeconds;
    }

}
