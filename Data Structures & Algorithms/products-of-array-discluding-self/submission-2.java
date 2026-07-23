class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p = 1;
        int n=nums.length;
        int[] f = new int[n];
        int[] pre = new int[n];
        int curr=1;
        for(int i=0;i<n;i++){
            f[i]=curr;
            curr*=nums[i];
        }
        curr=1;
        for(int i=n-1;i>=0;i--){
            f[i]*=curr;
            curr*=nums[i];
        }
        return f;
    }
}  
