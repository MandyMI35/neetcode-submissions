class Solution {
    public int orangesRotting(int[][] grid) {
        int tr = grid.length;
        int tc = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        HashSet<String> s = new HashSet<>();
        for (int i = 0; i < tr; i++) {
            for (int j = 0; j < tc; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    s.add(i + "," + j);
                }
            }
        }
        if (s.isEmpty()) return 0;
        int[][] dirns = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int time = -1;
        boolean[][] visited = new boolean[tr][tc];
        while (!q.isEmpty()) {
            int siz = q.size();
            for (int i = 0; i < siz; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirns) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= tr || nr < 0 || nc >= tc || nc < 0) {
                        continue;
                    }
                    if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                        s.remove(nr + "," + nc);
                        q.add(new int[] {nr, nc});
                        visited[nr][nc] = true;
                        grid[nr][nc] = 2;
                    }
                }
            }
            time++;
        }
        return s.isEmpty() ? time : -1;
    }
}
