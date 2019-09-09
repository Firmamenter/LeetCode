/**
355. Design Twitter

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);

Sol: Hashmap, heap, design
*/

class Twitter {
    // Created a hashmap to record user relationship
    // Key is user id, value is following users
    Map<Integer, Set<Integer>> relationship; 
    
    // History of all tweets 
    List<Tweet> tweets; 
    
    // Tweet class
    private class Tweet {
        int tweetId; 
        int userId; 
        
        Tweet(int tweetId, int userId) {
            this.tweetId = tweetId; 
            this.userId = userId; 
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        relationship = new HashMap<Integer, Set<Integer>>(); 
        tweets = new ArrayList<Tweet>(); 
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(tweetId, userId)); 
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>(); 
        Set<Integer> userOfInterest = relationship.getOrDefault(userId, new HashSet<Integer>()); 
        userOfInterest.add(userId); 
        int idx = tweets.size() - 1; 
        int cnt = 0; 
        while (cnt < 10 && idx >= 0) {
            if (userOfInterest.contains(tweets.get(idx).userId)) {
                result.add(tweets.get(idx).tweetId); 
                cnt++; 
            }
            idx--; 
        }
        return result; 
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return; 
        }
        if (!relationship.containsKey(followerId)) {
            relationship.put(followerId, new HashSet<Integer>()); 
        }
        relationship.get(followerId).add(followeeId); 
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !relationship.containsKey(followerId)) {
            return; 
        }
        relationship.get(followerId).remove(followeeId); 
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

// Slightly improved version
class Twitter {
    // Created a hashmap to record user relationship
    // Key is user id, value is following users
    Map<Integer, Set<Integer>> relationship; 
    
    // History of all tweets 
    Map<Integer, List<Tweet>> tweets; 
    
    // Min heap for getting k latest
    PriorityQueue<Tweet> minHeap; 
    
    // Tweet class
    private class Tweet {
        int tweetId; 
        int timestamp; 
        
        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId; 
            this.timestamp = timestamp; 
        }
    }
    
    // System timer
    private int timestamp; 
    private int cnt; 

    /** Initialize your data structure here. */
    public Twitter() {
        relationship = new HashMap<Integer, Set<Integer>>(); 
        tweets = new HashMap<Integer, List<Tweet>>(); 
        minHeap = new PriorityQueue<Tweet>(10, (a, b) -> a.timestamp - b.timestamp); 
        timestamp = 0; 
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<Tweet>()); 
        }
        tweets.get(userId).add(new Tweet(tweetId, timestamp++)); 
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>(); 
        Set<Integer> userOfInterest = relationship.getOrDefault(userId, new HashSet<Integer>()); 
        userOfInterest.add(userId); 
        for (Integer user: userOfInterest) {
            if (!tweets.containsKey(user)) {
                continue; 
            }
            for (Tweet tweet: tweets.get(user)) {
                minHeap.offer(tweet); 
                if (minHeap.size() > 10) {
                    minHeap.poll(); 
                }
            }
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().tweetId); 
        }
        Collections.reverse(result); 
        return result; 
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return; 
        }
        if (!relationship.containsKey(followerId)) {
            relationship.put(followerId, new HashSet<Integer>()); 
        }
        relationship.get(followerId).add(followeeId); 
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !relationship.containsKey(followerId)) {
            return; 
        }
        relationship.get(followerId).remove(followeeId); 
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