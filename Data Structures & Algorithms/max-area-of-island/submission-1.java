class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] vstd = new boolean[r][c];
        int max=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1 && !vstd[i][j]){
                    max = Math.max(max, dfs(grid,i,j,vstd,0));
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid, int i, int j, boolean[][] vstd, int ans){
        int r=grid.length;
        int c=grid[0].length;
        ans++;
        vstd[i][j]=true;
        int[][] dirn= {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] dir : dirn){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr>-1 && nc>-1 && nr<r && nc<c && grid[nr][nc]==1 && !vstd[nr][nc]){
                vstd[nr][nc]=true;
                ans+=dfs(grid,nr,nc,vstd,0);
            }
        }
        return ans;
    }
}
