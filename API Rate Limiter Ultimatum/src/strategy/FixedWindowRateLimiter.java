package strategy;

import model.RateLimiterConfig;
import model.User;
import model.UserWindow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class FixedWindowRateLimiter extends RateLimiter {
    /*
        what all things you will be needing inside the fixed window for each particular user
        - user => locks(Reentrant lock)

        First point which comes to our mind is -
        why locks are required ?
        to maintain concurrency among multiple users.
        if 2 users concurrently change something, then the changes should reflect
        accordingly.

        Now, why can't we use a global lock ? Why for every individual user, we are
        creating a lock ?
        Because each user's actions are independent from other user.
        Meaning we should block user1, if user2 enters the piece of code.
        User1 and user2 are independent.
        The point should be --> we should allow multiple parallel requests from the same
        user at the same time.
        But at the same time, we can allow different users for a course of action.

        - user => window

        2 maps -
        user : lock
        user : window
        And to take care of the concurrency, both maps will be concurrent hashmaps.
     */

    private Map<String, ReentrantLock> userLocks = new ConcurrentHashMap<>();
    private Map<String, UserWindow> userWindows = new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(RateLimiterConfig rateLimiterConfig) {
        super(rateLimiterConfig);
    }
    @Override
    public boolean allowRequest(User user) {
        String userId = user.getUserId();
        userLocks.putIfAbsent(userId, new ReentrantLock());
        ReentrantLock lock = userLocks.get(userId);

        // get the configurations.
        int maxRequests = rateLimiterConfig.getMaxRequest();
        long windowSize = rateLimiterConfig.getWindowInSec();

        lock.lock();
        try {

            // get the current window
            long currentWindow = (System.currentTimeMillis() / 1000)/ windowSize;

            // get the previous window of the user
            UserWindow prevWindow = userWindows.get(userId);

            // if the user is a new user or all of his previous requests belong to
            // a different window, the current request belong to a new window
            if(prevWindow == null || prevWindow.getWindowId() != currentWindow) {
                userWindows.put(userId, new UserWindow(currentWindow, 1));
                return true;
            }

            // no of requests < maxRequest
            if(prevWindow.getCount() < maxRequests) {
                prevWindow.setCount(prevWindow.getCount()+1);
                return true;
            }

            // limit crossed!!
            return false;
        } finally {
            lock.unlock();
        }
    }
}

