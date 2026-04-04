package strategy;

import enums.RateLimiterType;
import model.RateLimiterConfig;
import model.User;
import model.UserLog;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindowLogRateLimiter extends RateLimiter {
    // userId -> lock
    private Map<String, ReentrantLock> userLocks = new ConcurrentHashMap<>();

    // userId -> userLogs
    private Map<String, UserLog> userLogs = new ConcurrentHashMap<>();

    public SlidingWindowLogRateLimiter(RateLimiterConfig rateLimiterConfig, RateLimiterType rateLimiterType) {
        super(rateLimiterConfig, rateLimiterType);
    }

    @Override
    public boolean allowRequests(User user) {
        String userId = user.getUserId();
        userLocks.putIfAbsent(userId, new ReentrantLock());
        ReentrantLock userLock = userLocks.get(userId);

        int maxRequests = rateLimiterConfig.getMaxRequests();
        int windowSize = rateLimiterConfig.getWindowInSeconds();

        userLock.lock();
        try {

            long currTimestamp = System.currentTimeMillis()/1000;
            UserLog userlog = userLogs.get(userId);

            // get the logs for the user
            Deque<Long> logs;

            // new user
            if(userlog == null) {
                logs = new ArrayDeque<>();
                logs.addLast(currTimestamp);
                userLogs.putIfAbsent(userId, new UserLog(logs));
                return true;
            }

            logs = userlog.getTimestamps();

            // existing user
            // if the logs which are present inside the deque is out of the window,
            // then those logs are of no use - remove it from the deque
            while(!logs.isEmpty() && currTimestamp - logs.peekFirst() >= windowSize) {
                logs.pollFirst();
            }

            // now, from the left out logs - which are present inside the window - meaning
            // the relevant logs - if they are less than the maxRequests for an user,
            // then return true, else false
            if(logs.size() < maxRequests) {
                logs.addLast(currTimestamp);
                return true;
            }

            return false;
        } finally {
            userLock.unlock();
        }
    }
}
