class Solution {
    int rs, cs;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        rs = board.length;
        cs = board[0].length;
        visited = new boolean[rs][cs];
        for(int r=0;r<rs;r++){
            for(int c=0;c<cs;c++){
                if(dfs(board,word,r,c,0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int r, int c, int i){
        if(i==word.length()) return true;
        if(r<0 || c<0 || r>=rs || c>=cs || board[r][c]!=word.charAt(i) || visited[r][c]) return false;
        visited[r][c] = true;
        boolean res = dfs(board, word, r+1,c,i+1) || dfs(board, word, r-1,c,i+1) || dfs(board, word, r,c+1,i+1) || dfs(board, word, r,c-1,i+1);
        visited[r][c] = false;
        return res;
    }
}
