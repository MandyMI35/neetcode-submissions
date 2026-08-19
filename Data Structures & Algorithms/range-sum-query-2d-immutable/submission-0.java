class NumMatrix {
    int[][] mtx;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        mtx = new int[r][c];
        for(int i=0;i<r;i++){
            mtx[i][0]=matrix[i][0];
            for(int j=1;j<c;j++){
                mtx[i][j]=matrix[i][j]+mtx[i][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=0;
        for(int i=row1;i<=row2;i++){
            if(col1>0){
                res+=mtx[i][col2]-mtx[i][col1-1];
            } else {
                res+=mtx[i][col2];
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */