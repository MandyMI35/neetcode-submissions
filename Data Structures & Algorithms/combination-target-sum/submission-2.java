class Solution {
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,target,0,0,new ArrayList<>());
        return l;
    }
    public void dfs(int[] nums, int target, int i, int sum, List<Integer> temp){
        if(sum==target){
            l.add(new ArrayList<>(temp));
            return;
        }
        if(i==nums.length || sum>target) return;
        temp.add(nums[i]);
        dfs(nums,target,i,sum+nums[i],temp);
        temp.remove(temp.size()-1);
        dfs(nums,target,i+1,sum,temp);
    }
}

