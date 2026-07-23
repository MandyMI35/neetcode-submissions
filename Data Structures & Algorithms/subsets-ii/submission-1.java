class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();
        int idx=0, prev=0;
        l.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            idx = (i>0 && nums[i]==nums[i-1]) ? prev : 0;
            prev = l.size();
            for(int j=idx;j<prev;j++){
                List<Integer> temp = new ArrayList<>(l.get(j));
                temp.add(nums[i]);
                l.add(temp);
            }
        }
        return l;
    }
}
