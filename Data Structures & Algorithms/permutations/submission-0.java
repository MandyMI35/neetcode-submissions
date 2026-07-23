class Solution {
    HashSet<List<Integer>> s = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        rec(nums,new boolean[nums.length],new ArrayList<>());
        List<List<Integer>> l = new ArrayList<>(s);
        return l;
    }
    public void rec(int[] nums, boolean[] arr, List<Integer> l){
        if(nums.length==l.size()){
            s.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(arr[i]==false){
                arr[i]=true;
                l.add(nums[i]);
                rec(nums, arr,l);
                l.remove(l.size()-1);
                arr[i]=false;
            }
        }
    }
}
