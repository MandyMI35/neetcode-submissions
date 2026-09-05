class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==0) q.add(new int[]{i,j});
            }
        }
        int[][] dirns={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            for(int[] dirn :dirns){
                int nr = i+dirn[0];
                int nc = j+dirn[1];
                if(nr<0 || nc<0 || nr>=r || nc>=c) continue;
                if(grid[nr][nc]==2147483647){
                    grid[nr][nc]=grid[i][j]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}
