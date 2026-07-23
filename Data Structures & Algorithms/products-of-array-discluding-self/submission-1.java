class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prdct = 1;
        int[] f = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(j!=i){
                    prdct*=nums[j];
                }
            }
            f[i]=prdct;
            prdct=1;
        }
        return f;
    }
}  
