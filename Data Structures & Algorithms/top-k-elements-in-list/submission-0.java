class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for(int i : nums){
            if(!h.containsKey(i)){
                h.put(i,1);
            } else {
                int y=h.get(i);
                h.put(i,y+1);
            }
        }
        List<Map.Entry<Integer,Integer>> s = new ArrayList<>(h.entrySet());
        int[] f = new int[k];
        int j=0;
        s.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println(s);
        for(Map.Entry<Integer,Integer> e : s){
            int v = e.getValue();
            if(k==0){break;}
            f[j]=e.getKey();
            k--;
            j++;
        }
        return f;
    }
}
