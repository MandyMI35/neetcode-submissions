class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){return 0;}
        int counter=1;
        int maxc = 1;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                counter++;
                System.out.println(counter);
            } 
            else if ( nums[i]==nums[i-1]){continue;}
            else {
                counter=1;
            }
            maxc = Math.max(maxc, counter);
        }
        return maxc;
    }
}
