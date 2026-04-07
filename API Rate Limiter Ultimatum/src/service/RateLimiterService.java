package service;

import factory.RateLimiterFactory;
import model.User;
import strategy.RateLimiter;

public class RateLimiterService {
    private User user;
    public RateLimiterService(User user) {
        this.user = user;
    }

    public boolean allowRequest() {

        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(user);
        return rateLimiter.allowRequest(user);
    }
}
