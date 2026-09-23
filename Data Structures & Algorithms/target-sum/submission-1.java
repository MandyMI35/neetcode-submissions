class Solution {
    Map<String, Integer> hm = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,0,target,0);
    }
    public int dfs(int[] nums, int i, int target, int sum){
        if(i==nums.length) return sum==target ? 1 : 0;
        String key = i+","+sum;
        if(hm.containsKey(key)) return hm.get(key);
        hm.put(key,dfs(nums,i+1,target,sum+nums[i])+dfs(nums,i+1,target,sum-nums[i]));
        return hm.get(key);
    }
}
