class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        int end = nums.length-1;
        for(int i=0;i<=end;i++){
            if(nums[i]==val){
                int j=i;
                while(j<end){
                    nums[j]=nums[j+1];
                    j++;
                }
                nums[end]=val;
                end--;
                i--;
            }
        }
        return 1+end;
    }
}