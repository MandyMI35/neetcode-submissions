class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int s : stones) pq.offer(s);
        while(pq.size()>1){
            int m=pq.poll();
            int m2 = pq.poll();
            if(m>m2) pq.offer(m-m2);
        }
        return pq.size()==0 ? 0 : pq.peek();
    }
}
