class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int low=0;
        int high=row*col-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int midval = matrix[mid/col][mid%col];
            if(midval==target){
                return true;
            }
            if(midval>target){
                high = mid-1;
            }
            else if(midval<target){
                low = mid+1;
            }
        }
        return false;
    }
}
