class Solution {
    public boolean isValidSudoku(char[][] board) {
        // boolean f = true;
        for(int i=0;i<9;i++){
            HashSet<Character> h = new HashSet<>();
            for(int j=0;j<9;j++){
                char c =board[i][j];
                if(h.contains(c)  && c!='.'){
                    return false;
                }
                h.add(c);
            }
        }
        for(int i=0;i<9;i++){
            HashSet<Character> h = new HashSet<>();
            for(int j=0;j<9;j++){
                char c =board[j][i];
                if(h.contains(c) && c!='.'){
                    return false;
                }
                h.add(c);
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                HashSet<Character> h = new HashSet<>();
                for(int a=i*3;a<(i+1)*3;a++){
                    for(int b=j*3;b<(j+1)*3;b++){
                        char c =board[a][b];
                        if(h.contains(c) && c!='.'){
                            return false;
                        }
                        h.add(c);
                    }
                }
            }
        }
        return true;
    }
}
