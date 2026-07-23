class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.add(i);
        }
        if(pq.size()==1 || pq.size()==0){
            return pq.size()==0 ? 0 : pq.peek();
        }
        while(pq.size()!=1 && pq.size()!=0){
            int y=pq.poll();
            int x =pq.poll();
            if(y>x){
                pq.add(y-x);
            }
        }
        return pq.size()==0 ? 0 : pq.peek();
    }
}
