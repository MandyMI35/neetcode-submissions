class Solution {
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>());
        return l;
    }
    public void dfs(int[] nums, int i, List<Integer> temp){
        if(i==nums.length){
            l.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        int nxt=i+1;
        while(nxt<nums.length && nums[nxt]==nums[i]) nxt++;
        dfs(nums,i+1,temp);
        temp.remove(temp.size()-1);
        dfs(nums,nxt,temp);
    }
}
