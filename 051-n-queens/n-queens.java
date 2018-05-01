// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// Example:
//
//
// Input: 4
// Output: [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],
//
//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
//
//


class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>>res=new ArrayList<List<String>>();
        dfs(board,res,0);
        return res;
    }
    void dfs(char[][] board,List<List<String>>res,int start){
        if(start==board.length){
            res.add(construct(board));return;}
        for(int i=0;i<board.length;i++){
            if(valid(board,i, start)){
                board[i][start]='Q';
                dfs(board,res,start+1);
                board[i][start]='.';
            }
        }
    }
    boolean valid(char[][] board,int x, int y){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]=='Q'&&(x+j==y+i||x+y==i+j||x==i))
                    return false;
            }
        }
        return true;
        
    }
    List<String> construct(char[][] board){//put the board into List<String>
        List<String> b=new ArrayList<String>();
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            b.add(s);
        }
        return b;
        
    }
}
