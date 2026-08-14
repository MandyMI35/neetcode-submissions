class Solution {
    public void sortColors(int[] nums) {
        int[] clr = new int[3];
        for(int i : nums){
            clr[i]++;
        }
        for(int i=0;i<nums.length;i++){
            if(clr[0]!=0){
                nums[i]=0;
                clr[0]--;
            }
            else if(clr[1]!=0){
                nums[i]=1;
                clr[1]--;
            }
            else if(clr[2]!=0){
                nums[i]=2;
                clr[2]--;
            }
        }
    }
}