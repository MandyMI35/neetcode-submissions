class Solution {
    public int islandPerimeter(int[][] grid) {
        int tr=grid.length;
        int tc=grid[0].length;
        int peri=0;
        for(int i=0;i<tr;i++){
            for(int j=0;j<tc;j++){
                peri+=4*grid[i][j];
                if(i>0){
                    peri-=2*grid[i][j]*grid[i-1][j];
                }
                if(j>0){
                    peri-=2*grid[i][j]*grid[i][j-1];
                }
            }
        }
        return peri;
    }
}