class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] mat : matrix){
            if(target<=mat[mat.length-1]){
                int l =0, r=mat.length;
                while(l<r){
                    int m = l + (r-l)/2;
                    if(target==mat[m]) return true;
                    else if(target>mat[m]) l=m+1;
                    else if(target<mat[m]) r=m;
                }
            }
        }
        return false;
    }
}
