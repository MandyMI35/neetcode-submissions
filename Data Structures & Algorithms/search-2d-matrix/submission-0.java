class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int j=0;
        for(int i=0;i<row;i++){
            if(target<=matrix[i][col-1]){
                while(j<col){
                    if(matrix[i][j]==target){
                        return true;
                    }
                    j++;
                }
            }
            j=0;
        }
        return false;
    }
}
