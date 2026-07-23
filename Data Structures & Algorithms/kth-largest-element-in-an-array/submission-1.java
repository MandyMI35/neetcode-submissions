class Solution {
    public void qs(int[] nums, int low, int high, int k){
        if(low<high){
           int p = partition(nums,low,high);
            if(k-1==p){
                return;
            }
            if(k-1<p){
                qs(nums, low,p-1,k);
            } else {
                qs(nums, p+1,high,k);
            }
        }
    }
    public int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(nums[j]<pivot){
                i++;
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        i++;
        int temp = nums[i];
        nums[i]=nums[high];
        nums[high]=temp;
        return i;
    }
    public int findKthLargest(int[] nums, int k) {
        k=nums.length-k+1;
        qs(nums,0,nums.length-1, k);
        return nums[k-1];
    }
}
