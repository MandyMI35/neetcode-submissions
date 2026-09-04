class Solution {
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] vstd = new boolean[r][c];
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !vstd[i][j]){
                    dfs(grid,i,j,vstd);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j, boolean[][] vstd){
        int r=grid.length;
        int c=grid[0].length;
        vstd[i][j]=true;
        int[][] dirn = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] dir: dirn){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr>-1 && nc>-1 && nr<r && nc<c && grid[nr][nc]=='1' && !vstd[nr][nc]){
                vstd[nr][nc]=true;
                dfs(grid,nr,nc,vstd);
            }
        }
    }
}
