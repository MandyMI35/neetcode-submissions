class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : nums){
            count.put(i, count.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> hp = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            hp.offer(new int[]{entry.getValue(), entry.getKey()});
            if(hp.size()>k) hp.poll();
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = hp.poll()[1];
        }
        return res;
    }
}
