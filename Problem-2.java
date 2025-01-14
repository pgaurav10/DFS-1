// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    
    class Pair {
        int x;
        int y;
        
        Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i,j));
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int distance = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                Pair curr = q.poll();
                
                for(int[] dir:directions) {
                    int row = curr.getX()+dir[0];
                    int col = curr.getY()+dir[1];

                if(row>=0 && row<mat.length && col>=0 && col<mat[0].length && mat[row][col] == -1) {                                        mat[row][col] = distance+1;
                        q.add(new Pair(row,col));
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}