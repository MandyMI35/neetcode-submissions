class Solution {
    HashSet<List<Integer>> s = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        rec(nums,0,new ArrayList<>());
        List<List<Integer>> l = new ArrayList<>(s);
        return l;
    }
    public void rec(int[] nums, int idx, List<Integer> l){
        if(idx==nums.length){
            s.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[idx]);
        rec(nums,idx+1,l);
        l.remove(l.size()-1);
        while(idx + 1 < nums.length && nums[idx]==nums[idx+1]){
            idx++;
        }
        rec(nums,idx+1,l);
    }
}
