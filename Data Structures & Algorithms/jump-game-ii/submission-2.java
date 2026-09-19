class Solution {
    public int jump(int[] nums) {
        int l=0,r=0, ft=0;
        int jmp=0;
        while(r<nums.length-1){
            ft=0;
            for(int i=l;i<=r;i++) ft = Math.max(ft,i+nums[i]);
            l=r+1;
            r=ft;
            jmp++;
        }
        return jmp;
    }
}
