class Solution {
    public boolean exist(char[][] board, String word) {
        for(int j=0;j<board.length;j++){
            for(int i=0;i<board[0].length;i++){
                if(rec(board, j, i, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean rec(char[][] bd, int row, int col, String word, int idx){
        if(idx==word.length()){
            return true;
        }
        if(row<0 || col<0 || row>=bd.length || col>=bd[0].length || bd[row][col]!=word.charAt(idx) || bd[row][col]=='#'){
            return false;
        }
        bd[row][col]='#';
        boolean r = (
            rec(bd, row-1,col,word,idx+1) ||
            rec(bd, row+1,col,word,idx+1) ||
            rec(bd, row,col+1,word,idx+1) ||
            rec(bd, row,col-1,word,idx+1)
        );
        bd[row][col]=word.charAt(idx);
        return r;
    }
}