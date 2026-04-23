package strategy;

import model.RateLimiterConfig;
import model.User;

public abstract class RateLimiter {
    public RateLimiterConfig rateLimiterConfig = null;
    public RateLimiter(RateLimiterConfig rateLimiterConfig) {
        this.rateLimiterConfig = rateLimiterConfig;
    }
    public abstract boolean allowRequests(User user);
}
