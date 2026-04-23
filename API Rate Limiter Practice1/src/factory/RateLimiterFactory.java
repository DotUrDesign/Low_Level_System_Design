package factory;

import enums.UserTier;
import model.RateLimiterConfig;
import model.User;
import strategy.FixedWindowRateLimiter;
import strategy.RateLimiter;
import strategy.SlidingWindowLogRateLimiter;

public class RateLimiterFactory {
    public static RateLimiter getRateLimiter(User user) {
        if(user.getUserTier().equals(UserTier.FREE)) {
            return new FixedWindowRateLimiter(new RateLimiterConfig(10, 60));
        } else if(user.getUserTier().equals(UserTier.PREMIUM)){
            return new SlidingWindowLogRateLimiter(new RateLimiterConfig(100, 60));
        } else {
            return null;
        }
    }
}
