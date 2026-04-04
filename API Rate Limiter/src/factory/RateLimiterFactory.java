package factory;

import enums.RateLimiterType;
import model.RateLimiterConfig;
import strategy.FixedWindowRateLimiter;
import strategy.RateLimiter;
import strategy.SlidingWindowLogRateLimiter;
import strategy.TokenBucketRateLimiter;

public class RateLimiterFactory {
    public RateLimiter getRateLimiter(RateLimiterType type) {
        if(type.equals(RateLimiterType.TOKEN_BUCKET)) {
            return new TokenBucketRateLimiter();
        } else if(type.equals(RateLimiterType.FIXED_WINDOW)) {
            return new FixedWindowRateLimiter(
                            // 10 requests per 60 seconds
                            // maxRequests - 10
                            // window size - 60
                            new RateLimiterConfig(10,60),
                            RateLimiterType.FIXED_WINDOW
            );
        } else if(type.equals(RateLimiterType.SLIDING_WINDOW_LOG)) {
            return new SlidingWindowLogRateLimiter(
                    // 100 requests per min
                    // max requests allowed for an user - 100
                    // window size = 60 seconds
                    new RateLimiterConfig(100,60),
                    RateLimiterType.SLIDING_WINDOW_LOG
            );
        }
        return null;
    }
}
