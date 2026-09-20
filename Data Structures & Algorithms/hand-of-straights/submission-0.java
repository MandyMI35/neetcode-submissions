class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : hand){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }
        Queue<Integer> q = new LinkedList<>();
        int lnum=-1, og=0;
        for(int num : hm.keySet()){
            if((og>0 && num>lnum+1) || og>hm.get(num)) return false;
            q.add(hm.get(num)-og);
            lnum=num;
            og=hm.get(num);
            if(q.size()==groupSize) og-=q.poll();
        }
        return og==0;
    }
}
