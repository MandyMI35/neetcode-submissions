class Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        HashSet<String> visited = new HashSet<>();
        int tr = grid.length;
        int tc = grid[0].length;
        int[][] dirns = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<tr;i++){
            for(int j=0;j<tc;j++){
                if(i>-1 && j>-1 && i<tr && j<tc && grid[i][j]=='1' && !visited.contains(i+","+j)){
                    res++;
                    visited.add(i+","+j);
                    bfs(grid,i,j,visited, dirns);
                }
            }
        }
        return res;
    }
    public void bfs(char[][] grid, int r, int c,HashSet<String> visited, 
    int[][] dirns){
        int tr = grid.length;
        int tc = grid[0].length;
        for (int[] dir : dirns){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr>-1 && nc>-1 && nr<tr && nc<tc && grid[nr][nc]=='1' && !visited.contains(nr+","+nc)){
                visited.add(nr+","+nc);
                bfs(grid, nr, nc, visited, dirns);
            }
        }
    }
}