class Solution {
    int[][] dirn = {{1,0},{0,1},{-1,0},{0,-1}};
    int r;
    int c;
    public void solve(char[][] board) {
        r=board.length;
        c=board[0].length;
        boolean[][] vstd = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if ((i==0 || i==r-1 || j==0 || j==c-1) && !vstd[i][j] && board[i][j]=='O') dfs(board,vstd,i,j);
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if (board[i][j]=='O' && !vstd[i][j]) board[i][j]='X';
            }
        }
    }
    public void dfs(char[][] board, boolean[][] vstd, int i, int j){
        vstd[i][j]=true;
        for(int[] dir : dirn){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=r || nr<0 || nc<0 || nc>=c) continue;
            if(board[nr][nc]=='O' && !vstd[nr][nc]){
                dfs(board,vstd,nr,nc);
            }
        }
    }
}
