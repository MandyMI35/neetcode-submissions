class KthLargest {
    PriorityQueue<Integer> pq;
    int kth;
    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        pq = new PriorityQueue<>();
        kth = k;
        for(int i : nums){
            pq.add(i);
            if(pq.size()>kth){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        if (pq.size()<kth){
            pq.add(val);
            return pq.peek();
        }
        else if (val<pq.peek()){
            return pq.peek();
        } else {
            pq.add(val);
            pq.poll();
            return pq.peek();
        }
    }
}
