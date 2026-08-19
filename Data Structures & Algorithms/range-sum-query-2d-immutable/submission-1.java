class NumMatrix {
    int[][] mtx;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        mtx = new int[r+1][c+1];
        for(int i=0;i<r;i++){
            int pfx =0;
            for(int j=0;j<c;j++){
                pfx+=matrix[i][j];
                int above = mtx[i][j+1];
                mtx[i+1][j+1]=pfx+above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottomRight = mtx[row2][col2];
        int above = mtx[row1 - 1][col2];
        int left = mtx[row2][col1 - 1];
        int topLeft = mtx[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */