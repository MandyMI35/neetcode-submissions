class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, currs =0;
        Map<Integer, Integer> h = new HashMap<>();
        h.put(0,1);
        for(int i : nums){
            currs+=i;
            int diff = currs - k;
            res+=h.getOrDefault(diff, 0);
            h.put(currs, h.getOrDefault(currs,0)+1);
        }
        return res;
    }
}