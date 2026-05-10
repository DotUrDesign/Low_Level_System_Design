/*
    twitter
    - userMap => <userId, user>
    - timeCounter  => latest tweets

    User class
    - userId
    - list<integer> followers
    - list<tweet> tweets

    Tweet
    - timeCounter
    - tweetId


    methods of twitter class
    - post_tweet()
    - get_news_feed()
    - follow()
    - unfollow()

 */

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
    HashSet<Integer> followers;
    List<Tweet> tweets;
    public User(int userId) {
        this.userId = userId;
        this.followers = new HashSet<>();
        this.tweets = new LinkedList<>();
        followers.add(userId);
    }
    public void addTweet(Tweet tweet) {
        tweets.add(0, tweet);
    }
    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }
    public void removeFollower(int followeeId) {
        followers.remove(followeeId);
    }
}

public class Twitter {
    Map<Integer, User> userMap;
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
        if(!userMap.containsKey(userId)) {
            return new ArrayList();
        }

        User user = userMap.get(userId);
        // max heap based on timeCounter
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
                (a,b) -> b.timeCounter - a.timeCounter
        );
        int count = 0;
        for(Integer followerId : user.followers) {
            count = 0;
            for(Tweet tweet : userMap.get(followerId).tweets) {
                pq.offer(tweet);
            }
        }

        List<Integer> ans = new ArrayList<>();
        count = 0;
        while(!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            ans.add(tweet.tweetId);
            count++;
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

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
