class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int p = nums.length;
        HashSet<List<Integer>> f1 = new HashSet<>();
        // List<List<Integer>> f = new Arraylist<>();
        for(int i=0;i<p-1;i++){
            int n=-nums[i];
            int l=i+1;
            int r=p-1;
            while(l<r){
                if(nums[l]+nums[r]==n){
                    f1.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    // if(nums[l]==nums[l+1]){
                    //     l++;
                    // }
                    // if(nums[r]==nums[r-1]){
                    //     r--;
                    // }
                }
                else if(nums[l]+nums[r]<n){
                   l+=1; 
                }
                else if(nums[l]+nums[r]>n){
                   r-=1; 
                }
            }
        }
        return new ArrayList<>(f1);
    }
}
