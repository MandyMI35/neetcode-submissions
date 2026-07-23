class Solution {
    HashSet<List<Integer>> l= new HashSet<>();
    int[] nums1;
    int t;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        t=target;
        nums1=nums;
        summ(0,new ArrayList<>(), 0);
        List<List<Integer>> res = new ArrayList<>(l);
        return res;
    } 
    public void summ(int idx,List<Integer> a, int sum){
        if(sum==t){
            l.add(new ArrayList<>(a));
            return;
        }
        else if(sum>t || idx==nums1.length){
            return;
        }
        a.add(nums1[idx]);
        summ(idx,a,sum+nums1[idx]);
        a.remove(a.size()-1);
        a.add(nums1[idx]);
        summ(idx+1,a,sum+nums1[idx]);
        a.remove(a.size()-1);
        summ(idx+1,a,sum);
    }
}
