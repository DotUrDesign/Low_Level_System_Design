package factory;

import enums.UserTier;
import model.RateLimiterConfig;
import model.User;
import strategy.FixedWindowRateLimiter;
import strategy.RateLimiter;
import strategy.SlidingWindowLogRateLimiter;

public class RateLimiterFactory {
    public static RateLimiter getRateLimiter(User user) {
        UserTier tier = user.getUserTier();
        if(tier.equals(UserTier.FREE)) {
            return new FixedWindowRateLimiter(new RateLimiterConfig(10,60));
        } else if(tier.equals(UserTier.PREMIUM)) {
            return new SlidingWindowLogRateLimiter(new RateLimiterConfig(100, 60));
        }
        return null;
    }
}
