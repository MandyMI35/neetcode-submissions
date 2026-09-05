class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] {i, j});
            }
        }
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];
                int[][] dirn = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                for(int[] dir : dirn){
                    int nr = i+dir[0];
                    int nc=j+dir[1];
                    if(nr<0 || nc<0 || nr>=r || nc>=c) continue;
                    if(grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return time == 0 ? 0 : time - 1;
    }
}
