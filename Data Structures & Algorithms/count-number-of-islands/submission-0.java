class Solution {
    public class Pair{
        int f;
        int s;
        public Pair(int _f, int _s){
            this.f = _f;
            this.s = _s;
        }

    }

    static int[][] dir = {{1,0}, {0,1},{-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for(boolean[] v : vis) Arrays.fill(v, false);
        int sp = 0;
        for(int row = 0; row < n; row++){
            for(int col= 0; col<m; col++){
                if(grid[row][col] == '1' && vis[row][col] == false){
                    countIsl(grid,row, col, n, m, vis);
                    sp++;
                }
            }
        }
        return sp;
    }

    public void countIsl(char[][] grid, int row, int col, int n, int m,  boolean[][] vis ){ 
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int curR = p.f;
            int curC = p.s;
            for(int[] d : dir){
                int newR = curR + d[0];
                int newC = curC + d[1];

                if(newR >= 0 && newC >= 0 && newR < n && newC < m && grid[newR][newC] == '1' && vis[newR][newC] == false){
                    vis[newR][newC] = true;
                    q.add(new Pair(newR, newC));
                }
            }
        }
    }
}