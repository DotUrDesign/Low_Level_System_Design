package strategy;

import model.RateLimiterConfig;
import model.User;
import model.UserLog;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindowLogRateLimiter extends RateLimiter {
    /*
        here for a particular user -
        you will be storing 2 things for a corresponding user -
        1. userId : lock
        2. userId : logs

        for the logs -> Deque<> which will be based on the algo => FIFO
        First in first out.
     */

    private Map<String, ReentrantLock> userLocks = new ConcurrentHashMap<>();
    private Map<String, UserLog> userLogs = new ConcurrentHashMap<>();

    public SlidingWindowLogRateLimiter(RateLimiterConfig rateLimiterConfig) {
        super(rateLimiterConfig);
    }

    @Override
    public boolean allowRequest(User user) {
        String userId = user.getUserId();
        userLocks.putIfAbsent(userId, new ReentrantLock());
        ReentrantLock lock = userLocks.get(userId);
        int maxRequests = rateLimiterConfig.getMaxRequest();
        long windowSize = rateLimiterConfig.getWindowInSec();

        lock.lock();
        try {
            long currTime = (System.currentTimeMillis()/1000);
            UserLog userlogs = userLogs.get(userId);
            Deque<Long> logs;
            if(userlogs == null) {
                logs = new ArrayDeque<>();
                logs.add(currTime);
                userLogs.put(userId, new UserLog(logs));
                return true;
            }

            logs = userlogs.getTimestamps();
            while(!logs.isEmpty() && currTime - logs.peekFirst() > windowSize) {
                logs.pollFirst();
            }

            if(logs.size() < maxRequests) {
                logs.addLast(currTime);
                return true;
            }

            return false;
        } finally {
            lock.unlock();
        }
    }
}
