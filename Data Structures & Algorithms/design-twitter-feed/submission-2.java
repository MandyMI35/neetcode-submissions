class Twitter {
    int time;
    List<int[]>[] tweets;
    Set<Integer>[] followees;
    public Twitter() {
        time=0;
        tweets = new List[501];
        followees = new Set[501];
    }
    
    public void postTweet(int userId, int tweetId) {
        time+=1;
        if(tweets[userId]==null){
            tweets[userId] = new ArrayList<>();
            follow(userId, userId);
        }
        tweets[userId].add(new int[]{time, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(followees[userId]==null){
            return new ArrayList<>();
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        List<Integer> l = new ArrayList<>();
        for(int f : followees[userId]){
            if(tweets[f]==null){
                continue;
            }
            for(int[] tweet : tweets[f]){
                pq.add(tweet);
            }
        }
        while(!pq.isEmpty() && l.size()<10){
            int[] temp=pq.poll();
            l.add(temp[1]);
        }
        return l;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followees[followerId]==null){
            followees[followerId] = new HashSet<>();
        }
        followees[followerId].add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followees[followerId]!=null && followerId!=followeeId){
            followees[followerId].remove(followeeId);
        }
    }
}