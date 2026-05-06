import java.util.*;

class Tweet {
    int timeCounter;
    int tweetId;
    public Tweet(int timeCounter, int tweetId) {
        this.timeCounter = timeCounter;
        this.tweetId = tweetId;
    }
}

class User {
    int userId;
    List<Tweet> tweets;
    HashSet<Integer> followers;
    public User(int userId){
        this.userId = userId;
        this.tweets = new LinkedList<>();
        this.followers = new HashSet<>();
        followers.add(userId);
    }
    public void addTweet(Tweet tweet) {
        tweets.add(0,tweet);  // 0 means insertion at head
    }
    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }
    public void removeFollower(int followeeId) {
        followers.remove(followeeId);
    }
}

class Twitter {
    Map<Integer,User> userMap;
    int timeCounter;
    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }

        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
                (a,b) -> b.timeCounter - a.timeCounter
        );
        if(!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }
        User user = userMap.get(userId);
        int count = 0;
        for(Integer followerId : user.followers) {
            count = 0;
            for(Tweet tweet : userMap.get(followerId).tweets) {
                pq.offer(tweet);
                count++;
                if(count >= 10) {
                    break;
                }
            }
        }

        count = 10;
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty() && count > 0) {
            Tweet t = pq.poll();
            ans.add(t.tweetId);
            count--;
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if(!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        User user = userMap.get(followerId);
        user.addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return;
        }

        User user = userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */