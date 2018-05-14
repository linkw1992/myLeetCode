// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
//
// Input:
// 11110
// 11010
// 11000
// 00000
//
// Output: 1
//
//
// Example 2:
//
//
// Input:
// 11000
// 11000
// 00100
// 00011
//
// Output: 3
//
//


class Solution {
    int row,col;  
    public int numIslands(char[][] grid) {
        int res=0;
        if(grid.length==0)return res;
        row=grid.length;//do not DEFINE it here!
        col=grid[0].length;
        for(int i=0;i<row;i++){
        for(int j=0;j<col;j++)
            if(grid[i][j]=='1')//grid will change during dfs
            {dfs(grid,i,j);
           res++; 
        }
        }
        return res;
    }
    void dfs(char[][] grid,int i,int j){
        if(i<0||j<0||i>=row||j>=col||grid[i][j]=='0')return;//egde
        grid[i][j]='0';//key step
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
