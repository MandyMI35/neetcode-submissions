class Solution {
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] track = new boolean[nums.length];
        dfs(nums,track,new ArrayList<>());
        return l;
    }
    public void dfs(int[] nums, boolean[] track, List<Integer> temp){
        if(nums.length==temp.size()){
            l.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!track[i]){
                temp.add(nums[i]);
                track[i]=true;
                dfs(nums,track,temp);
                temp.remove(temp.size()-1);
                track[i]=false;
            }
        }
    }
}
