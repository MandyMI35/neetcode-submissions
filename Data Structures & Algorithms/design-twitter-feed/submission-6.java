class Twitter {
    HashMap<Integer, List<Integer>> l;
    PriorityQueue<int[]> pq;
    int time;
    public Twitter() {
        l = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        pq.add(new int[] {tweetId, userId, time});
        if (!l.containsKey(userId)) {
            l.put(userId, new ArrayList<>());
            l.get(userId).add(userId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<Integer> follow = l.get(userId);
        if (follow == null) {
            follow = new ArrayList<>();
            follow.add(userId);
        }

        PriorityQueue<int[]> temp = new PriorityQueue<>(pq);

        while (!temp.isEmpty() && res.size() < 10) {
            int[] arr = temp.poll();

            if (follow.contains(arr[1])) {
                res.add(arr[0]);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!l.containsKey(followerId)) {
            l.put(followerId, new ArrayList<>());
            l.get(followerId).add(followerId);
        }
        if (!l.get(followerId).contains(followeeId)) {
            l.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        l.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
