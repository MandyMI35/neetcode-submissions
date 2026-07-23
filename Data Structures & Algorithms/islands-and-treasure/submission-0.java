class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int tr = grid.length;
        int tc = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < tr; i++) {
            for (int j = 0; j < tc; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] dirns = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dirn: dirns){
                int nr = r + dirn[0];
                int nc = c + dirn[1];
                if(nr<0 || nr>=tr || nc<0 || nc>=tc){continue;}
                if(grid[nr][nc]==2147483647){
                    grid[nr][nc] = grid[r][c] +1;
                    q.add(new int[]{nr,nc});
                }
            }
        }

    }
}
