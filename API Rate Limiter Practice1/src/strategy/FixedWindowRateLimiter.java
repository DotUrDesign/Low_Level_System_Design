package strategy;

import model.RateLimiterConfig;
import model.User;
import model.UserWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class FixedWindowRateLimiter extends RateLimiter {
    public Map<Integer, ReentrantLock> userLockMap = new HashMap<>(); // userId -> Lock
    public Map<Integer, UserWindow> userWindowMap = new HashMap<>();  // userId -> window

    public FixedWindowRateLimiter(RateLimiterConfig rateLimiterConfig) {
        super(rateLimiterConfig);
    }

    @Override
    public boolean allowRequests(User user) {
        Integer userId = user.getUserId();
        userLockMap.putIfAbsent(userId, new ReentrantLock());
        ReentrantLock userLock = userLockMap.get(userId);

        int maxRequests = rateLimiterConfig.getMaxRequests();
        long windowInSec = rateLimiterConfig.getWindowInSec();

        userLock.lock();
        try {
            long currentWindow = (System.currentTimeMillis() / 1000 ) / windowInSec;
            UserWindow prevWindow = userWindowMap.get(userId);
            if(prevWindow == null || prevWindow.getWindowId() != currentWindow) {
                // new user
                UserWindow userWindow = new UserWindow(currentWindow, 1);
                userWindowMap.put(userId, userWindow);
                return true;
            }

            if(prevWindow.getNoOfReq() < maxRequests) {
                prevWindow.setNoOfReq(prevWindow.getNoOfReq()+1);
                return true;
            }

            return false;
        } finally {
            userLock.unlock();
        }

    }
}
