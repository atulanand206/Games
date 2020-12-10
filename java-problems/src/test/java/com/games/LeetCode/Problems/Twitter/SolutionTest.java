package com.games.LeetCode.Problems.Twitter;

import com.games.chess.utils.ListUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testTwitter() {
        Solution.Twitter twitter = new Solution.Twitter();
        twitter.postTweet(1, 5);
        ListUtils.print(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        ListUtils.print(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        ListUtils.print(twitter.getNewsFeed(1));
    }

    @Test
    void testTwitter2() {
        Solution.Twitter twitter = new Solution.Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 1);
        ListUtils.print(twitter.getNewsFeed(1));
    }

    @Test
    void testTwitter3() {
        Solution.Twitter twitter = new Solution.Twitter();
        twitter.postTweet(2, 5);
        twitter.follow(1, 2);
        twitter.follow(1, 2);
        ListUtils.print(twitter.getNewsFeed(1));
    }
}