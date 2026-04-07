package strategy;

import model.RateLimiterConfig;
import model.User;
/*
    Why we took abstract class -
    to declare the constructor which can set the parameters => ratelimiter config
    rate limiter type.
 */
public abstract class RateLimiter {
    public RateLimiterConfig rateLimiterConfig;
    public RateLimiter(RateLimiterConfig rateLimiterConfig) {
        this.rateLimiterConfig = rateLimiterConfig;
    }
    public abstract boolean allowRequest(User user);
}

