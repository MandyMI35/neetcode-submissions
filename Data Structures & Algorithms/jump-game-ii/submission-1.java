class Solution {
    public int jump(int[] nums) {
        int res=0, l=0, r=0;
        while(r<nums.length-1){
            int ft = 0;
            for(int i=l;i<=r;i++){
                ft = Math.max(ft, i+nums[i]);
            }
            l=r+1;
            r=ft;
            res++;
        }
        return res;
    }
}
