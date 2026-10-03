class Solution {
    int[][] dirn = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    Queue<int[]> q = new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] vst = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,vst);
                    return bfs(grid,q,vst);
                }
            }
        }
        return 0;
    }
    public void dfs(int[][] grid, int i, int j, boolean[][] vst) {
        int r = grid.length;
        int c = grid[0].length;
        vst[i][j] = true;
        q.offer(new int[] {i, j});
        for (int[] dir : dirn) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr < 0 || nc < 0 || nr >= r || nc >= c)
                continue;
            if (grid[nr][nc] == 1 && !vst[nr][nc]) {
                dfs(grid, nr, nc, vst);
            }
        }
    }
    public int bfs(int[][] grid, Queue<int[]> q, boolean[][] vst) {
        int res = 0;
        int r = grid.length;
        int c = grid[0].length;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirn) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if (nr < 0 || nc < 0 || nr >= r || nc >= c)
                        continue;
                    if (grid[nr][nc] == 1 && !vst[nr][nc]) {
                        return res;
                    }
                    if (grid[nr][nc] == 0 && !vst[nr][nc]) {
                        vst[nr][nc]=true;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            res++;
        }
        return res;
    }
}