class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }
        int n = nums.length/3;
        List<Integer> l = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
            if(e.getValue()>n) l.add(e.getKey());
        }
        return l;
    }
}