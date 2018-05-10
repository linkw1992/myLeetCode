// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// Example:
//
//
// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
//
// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
//
//


class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w=word.toCharArray();
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[x].length;y++){
                if(yes(board,x,y,w,0))return true;//until yes is true
            }
        }
        return false;
    }
    boolean yes(char[][] board, int x, int y,char[] w,int i){
        if(i==w.length)return true;//dfs
        if(x<0||y<0||x==board.length||y==board[x].length)return false;//overflow
        if(board[x][y]!=w[i])return false;//this element not match
        board[x][y]^=256;//mark for been used
        boolean yes=yes(board,x+1,y,w,i+1)
            ||yes(board,x,y+1,w,i+1)
            ||yes(board,x-1,y,w,i+1)
            ||yes(board,x,y-1,w,i+1);        
            board[x][y]^=256;//change back
            return yes;
    }
}
