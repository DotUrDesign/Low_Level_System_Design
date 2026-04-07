package strategy;

import model.RateLimiterConfig;
import model.User;

public class TokenBucketRateLimiter extends RateLimiter {
    public TokenBucketRateLimiter(RateLimiterConfig rateLimiterConfig) {
        super(rateLimiterConfig);
    }

    @Override
    public boolean allowRequest(User user) {
        return false;
    }
}
