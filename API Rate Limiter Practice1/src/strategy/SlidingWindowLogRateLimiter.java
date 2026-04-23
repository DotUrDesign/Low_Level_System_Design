package strategy;

import model.RateLimiterConfig;
import model.User;
import model.UserLog;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindowLogRateLimiter extends RateLimiter {
    public Map<Integer, ReentrantLock> userLockMap = new HashMap<>();
    public Map<Integer, UserLog> userLogMap = new HashMap<>();
    public SlidingWindowLogRateLimiter(RateLimiterConfig rateLimiterConfig) {
        super(rateLimiterConfig);
    }

    @Override
    public boolean allowRequests(User user) {
        Integer userId = user.getUserId();
        userLockMap.putIfAbsent(userId, new ReentrantLock());
        ReentrantLock userLock = userLockMap.get(userId);

        int maxRequests = rateLimiterConfig.getMaxRequests();
        long windowSize = rateLimiterConfig.getWindowInSec();

        userLock.lock();
        try {
            long currentTime = System.currentTimeMillis()/1000;
            UserLog userlog = userLogMap.getOrDefault(userId, null);
            Deque<Long> logs = null;
            if(userlog == null) {
                // new user
                logs = new ArrayDeque<>();
                logs.add(currentTime);
                userLogMap.put(userId, new UserLog(logs));
                return true;
            }

            logs = userlog.getTimestamps();
            while(!logs.isEmpty() && currentTime - logs.peekFirst() > windowSize) {
                logs.pollFirst();
            }

            if(logs.size() < maxRequests) {
                logs.addLast(currentTime);
                return true;
            }

            return false;
        } finally {
            userLock.unlock();
        }
    }
}
