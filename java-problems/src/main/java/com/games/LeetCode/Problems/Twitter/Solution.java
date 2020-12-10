package com.games.LeetCode.Problems.Twitter;

import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.*;

public class Solution {

    static class Tweet {

        private static int tweetCount = 0;
        final int tweetId;
        final int tweetTime;

        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.tweetTime = tweetCount++;
        }
    }

    static class User {
        final int userId;
        final List<Tweet> tweets = new ArrayList<>();
        final List<User> followers = new ArrayList<>();

        User(int userId) {
            this.userId = userId;
        }

        public void postTweet(Tweet tweet) {
            tweets.add(tweet);
        }
    }

    static class Twitter {

        final List<User> users = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            User user = getUser(userId);
            user.postTweet(tweet);
        }

        @NonNull
        private User getUser(int userId) {
            for (User user : users)
                if (user.userId == userId)
                    return user;
            User user = new User(userId);
            users.add(user);
            return user;
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            User user = getUser(userId);
            List<Tweet> tweets = new ArrayList<>(user.tweets);
            List<User> followerIds = user.followers;
            for (User follower : followerIds)
                tweets.addAll(follower.tweets);
            tweets.sort(Comparator.comparing(t -> t.tweetTime));
            Collections.reverse(tweets);
            List<Integer> tweetIds = new ArrayList<>();
            for (int i = 0; i < 10 && i < tweets.size(); i++)
                tweetIds.add(tweets.get(i).tweetId);
            return tweetIds;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (followeeId == followerId)
                return;
            User follower = getUser(followerId);
            User followee = getUser(followeeId);
            if (!follower.followers.contains(followee))
                follower.followers.add(followee);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followeeId == followerId)
                return;
            User follower = getUser(followerId);
            User followee = getUser(followeeId);
            follower.followers.remove(followee);
        }
    }
}
