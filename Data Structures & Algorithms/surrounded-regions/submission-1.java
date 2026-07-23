class Solution {
    public void solve(char[][] board) {
        int tr=board.length;
        int tc=board[0].length;
        for(int i=0;i<tr;i++){
            dfs(board, i,0);
            dfs(board, i,tc-1);
        }
        for(int j=0;j<tc;j++){
            dfs(board, 0,j);
            dfs(board, tr-1,j);
        }
        for(int i=0;i<tr;i++){
            for(int j=0;j<tc;j++){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
                if (board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board, int r, int c){
        int tr=board.length;
        int tc=board[0].length;
        if(r<0 ||  r>=tr || c<0 || c>=tc || board[r][c]!='O'){return;}
        board[r][c]='T';
        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }
}
