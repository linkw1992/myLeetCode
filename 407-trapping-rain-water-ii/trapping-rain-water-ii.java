// Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
//
//
// Note:
// Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
//
//
// Example:
//
// Given the following 3x6 height map:
// [
//   [1,4,3,1,3,2],
//   [3,2,1,3,2,4],
//   [2,3,3,2,3,1]
// ]
//
// Return 4.
//
//
//
//
//
// The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
//
//
//
//
// After the rain, water is trapped between the blocks. The total volume of water trapped is 4.
//


public class Solution {
    public class Cell{//convienient for manipulate
        int col;
        int row;
        int height;
        public Cell(int row,int col,int height){
            this.col=col;
            this.row=row;
            this.height=height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length==0||heightMap[0].length==0)return 0;
        PriorityQueue<Cell> q=new PriorityQueue<>(1,new Comparator<Cell>(){//put element according to index
        public int compare(Cell a,Cell b){
            return a.height-b.height;
        }});
        boolean[][] visited= new boolean[heightMap.length][heightMap[0].length];
        for(int i=0;i<heightMap.length;i++){//edge put to queue
            visited[i][0]=true;
            visited[i][heightMap[0].length-1]=true;
            q.offer(new Cell(i,0,heightMap[i][0]));
            q.offer(new Cell(i,heightMap[0].length-1,heightMap[i][heightMap[0].length-1]));
        }for(int j=0;j<heightMap[0].length;j++){//edge put to queue
            visited[0][j]=true;
            visited[heightMap.length-1][j]=true;
            q.offer(new Cell(0,j,heightMap[0][j]));
            q.offer(new Cell(heightMap.length-1,j,heightMap[heightMap.length-1][j]));
        }
        int res=0;
        int[][] dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            Cell cell=q.poll();
            for(int[] d:dir){
                int row=cell.row+d[0];
                int col=cell.col+d[1];
                if(row>=0&&row<heightMap.length&&col>=0&&col<heightMap[0].length&&!visited[row][col]){//check edge and tag
                    visited[row][col]=true;//tag
                    res+=Math.max(0,cell.height-heightMap[row][col]);//check neighbor
                    q.offer(new Cell(row,col,Math.max(heightMap[row][col],cell.height)));//offer all the neighbors
                }
                
            }
        }
        return res;
    }
}
