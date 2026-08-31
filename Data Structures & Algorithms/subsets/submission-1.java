class Solution {
    HashSet<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        dfs(nums,0, new ArrayList<>());
        for(List<Integer> r : res) l.add(r);
        return l;
    }
    public void dfs(int[] nums, int i, List<Integer> temp){
        if(i==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        dfs(nums,i+1, temp);
        temp.add(nums[i]);
        dfs(nums,i+1,temp);
        temp.remove(temp.size()-1);
    }
}
