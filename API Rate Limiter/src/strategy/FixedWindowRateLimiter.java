package strategy;

import enums.RateLimiterType;
import model.RateLimiterConfig;
import model.User;
import model.UserWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class FixedWindowRateLimiter extends RateLimiter {
    private Map<String, ReentrantLock> userLocks = new ConcurrentHashMap<>();  // userId -> Locks
    private Map<String, UserWindow> userWindows = new ConcurrentHashMap<>();    // userId -> UserWindow{window,count}

    public FixedWindowRateLimiter(RateLimiterConfig config, RateLimiterType type) {
        super(config, type);
    }

    @Override
    public boolean allowRequests(User user) {
        String userId = user.getUserId();
        userLocks.putIfAbsent(userId, new ReentrantLock());
        ReentrantLock userLock = userLocks.get(userId);

        userLock.lock();
        try {
            int maxRequests = rateLimiterConfig.getMaxRequests();
            int windowInSec = rateLimiterConfig.getWindowInSeconds();

            long currWindow = (System.currentTimeMillis()/1000)/windowInSec;
            UserWindow userWindow = userWindows.getOrDefault(userId, null);

            // if the user is completely new or the user is new to the curren window
            if(userWindow == null || userWindow.getWindowInSec() != currWindow) {
                userWindows.put(userId, new UserWindow(currWindow,1));
                return true;
            }

            // if the user is not new to the current window
            // check - if the requests from the user < maxRequests
            if(userWindow.getCount() < maxRequests) {
                userWindow.setCount(userWindow.getCount() + 1);
                return true;
            }

            return false;
        } finally {
            userLock.unlock();
        }
    }
}
