class Solution {
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0,0,new ArrayList<>());
        return l;
    }
    public void dfs(int[] nums, int target, int sum, int i, List<Integer> temp){
        if(sum==target){
            l.add(new ArrayList<>(temp));
            return;
        }
        if(i==nums.length || sum>target) return;
        temp.add(nums[i]);
        dfs(nums,target,sum+nums[i],i+1,temp);
        temp.remove(temp.size()-1);
        int next = i+1;
        while(next<nums.length && nums[next]==nums[i]) next++;
        dfs(nums,target,sum,next,temp);
    }
}
