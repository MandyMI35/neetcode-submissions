class Solution {
    int[][] dirn = {{1,0},{0,1},{0,-1},{-1,0}};
    int r;
    int c;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        r=heights.length;
        c=heights[0].length;
        boolean[][] pac = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];
        for(int i=0;i<r;i++){
            dfs(heights,atl,i,c-1);
            dfs(heights,pac,i,0);
        }
        for(int i=0;i<c;i++){
            dfs(heights,pac,0,i);
            dfs(heights,atl,r-1,i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(pac[i][j] && atl[i][j]) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    public void dfs(int[][] heights, boolean[][] vstd, int i, int j){
        vstd[i][j]=true;
        for(int[] dir : dirn){
            int nr = dir[0]+i;
            int nc=dir[1]+j;
            if(nr<0 || nc<0 || nr>=r || nc>=c) continue;
            if(!vstd[nr][nc] && heights[nr][nc]>=heights[i][j]) dfs(heights,vstd,nr,nc);
        }
    }
}
