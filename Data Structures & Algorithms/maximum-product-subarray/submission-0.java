class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int j=1;j<nums.length;j++){
            int i=nums[j];
            int temp=max;
            max=Math.max(i,Math.max(temp*i, min*i));
            min=Math.min(i,Math.min(temp*i, min*i));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}