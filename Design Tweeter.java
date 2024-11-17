/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
*/
class Tweets implements Comparable<Tweets>{
    int time;
    int tweetId;
    Tweets(int time, int id){
        this.time = time;
        this. tweetId = id;
    }

    //Overriding compare method
    public int compareTo(Tweets that){
        return that.time - this.time;
    }
}

class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweets> tweets;
    User(int id){
        this.userId = id;
        followers = new HashSet<>();
        tweets = new LinkedList<>();
    }
    public void addTweet(Tweets t){
        tweets.add(0 , t);
    }

    public void addFollower(int followeeId){
        followers.add(followeeId);
    }
    
    public void removeFollower(int followeeId){
        followers.remove(followeeId);
    }
}
class Twitter {
    HashMap<Integer, User> userMap = new HashMap<>();
    int timeCounter;
    public Twitter() {
        userMap = new HashMap<>();
        timeCounter=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }

        User user = userMap.get(userId);
        user.addTweet(new Tweets(timeCounter, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)){
            return new ArrayList<>();
        }

        PriorityQueue<Tweets> pq = new PriorityQueue<>();

        User user = userMap.get(userId);
        int count=0;
        for(int followerId: user.followers){
            for(Tweets tweet: userMap.get(followerId).tweets){
                pq.offer(tweet);
                count++;
                if(count > 10){
                    break;
                }
            }
        }
        count = 0;
        for(Tweets tweet: user.tweets){
            pq.offer(tweet);
            count++;
            if(count > 10){
                break;
            }
        }

        List<Integer> res = new ArrayList<>();
        int indx = 0;
        while(!pq.isEmpty() && indx < 10){
            Tweets tweet = pq.poll();
            res.add(tweet.tweetId);
            indx++;
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
           userMap.put(followerId, new User(followerId));
        }

        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new User(followeeId));
        }
        User user = userMap.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
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
