class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for(int i:nums){
            h.add(i);
        }
        int res =0;
        for(int i=0;i<nums.length;i++){
            if(!h.contains(nums[i]-1)){
                int l=1;
                while(h.contains(nums[i]+l)){
                    l++;
                }
                res = Math.max(res,l);
            }
        }
        return res;
    }
}
