class Solution {
    List<List<Integer>> l2 = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        recur(nums,0,new ArrayList<>());
        return l2;
    }
    public void recur(int[] nums, int i, List<Integer> l){
        if(i==nums.length){
            l2.add(new ArrayList<>(l));
            return;
        }
        recur(nums,i+1,l);
        l.add(nums[i]);
        recur(nums,i+1,l);
        l.remove(l.size()-1);
    }
}
