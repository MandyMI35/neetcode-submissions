class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int tr = heights.length;
        int tc = heights[0].length;

        HashSet<String> atl = new HashSet<>();
        HashSet<String> pac = new HashSet<>();

        for (int i = 0; i < tr; i++) {
            for (int j = 0; j < tc; j++) {
                if (i == 0 || j == 0) {
                    pac.add(i + "," + j);
                    dfsp(heights, new boolean[tr][tc], pac, i, j);
                }
                if (i == tr - 1 || j == tc - 1) {
                    atl.add(i + "," + j);
                    dfsa(heights, new boolean[tr][tc], atl, i, j);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < tr; i++) {
            for (int j = 0; j < tc; j++) {
                if (pac.contains(i + "," + j) && atl.contains(i + "," + j)) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void dfsa(int[][] heights, boolean[][] vsd, HashSet<String> atl, int r, int c) {
        int tr = heights.length;
        int tc = heights[0].length;

        vsd[r][c] = true;

        int[][] dirns = {{0,1},{1,0},{-1,0},{0,-1}};

        for (int[] dir : dirns) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= tr || nc < 0 || nc >= tc)
                continue;

            if (!vsd[nr][nc] && heights[nr][nc] >= heights[r][c]
                    && !atl.contains(nr + "," + nc)) {

                atl.add(nr + "," + nc);
                vsd[nr][nc] = true;
                dfsa(heights, vsd, atl, nr, nc);
            }
        }
    }

    public void dfsp(int[][] heights, boolean[][] vsd, HashSet<String> pac, int r, int c) {
        int tr = heights.length;
        int tc = heights[0].length;

        vsd[r][c] = true;

        int[][] dirns = {{0,1},{1,0},{-1,0},{0,-1}};

        for (int[] dir : dirns) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= tr || nc < 0 || nc >= tc)
                continue;

            if (!vsd[nr][nc] && heights[nr][nc] >= heights[r][c]
                    && !pac.contains(nr + "," + nc)) {

                pac.add(nr + "," + nc);
                vsd[nr][nc] = true;
                dfsp(heights, vsd, pac, nr, nc);
            }
        }
    }
}