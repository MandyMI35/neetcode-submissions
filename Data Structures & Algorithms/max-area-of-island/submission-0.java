class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int tr = grid.length;
        int tc = grid[0].length;
        int[][] dirns = {{1,0},{0,1},{-1,0},{0,-1}};
        int max=0;
        HashSet<String> visited = new HashSet<>();
        for(int i=0;i<tr;i++){
            for(int j=0;j<tc;j++){
                if(i<tr && j<tc && i>-1 && j>-1 && grid[i][j]==1 
                && !visited.contains(i+","+j)){
                    visited.add(i+","+j);
                    int res = dfs(grid, visited,i,j,dirns);
                    System.out.println(i+","+j);
                    if(res>max){max=res;}
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid, HashSet<String> visited, int r, int c, int[][] dirns){
        int tr = grid.length;
        int tc = grid[0].length;
        int res =1;
        for(int[] dirn : dirns){
            int nr = r+dirn[0];
            int nc = c+dirn[1];
            if(nr<tr && nc<tc && nr>-1 && nc>-1 && grid[nr][nc]==1 && !visited.contains(nr+","+nc)){
                visited.add(nr+","+nc);
                res +=dfs(grid, visited,nr,nc,dirns);
                System.out.println(nr+","+nc);
            }
        }
        return res;
    }
}
