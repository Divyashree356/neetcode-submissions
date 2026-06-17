class Solution {
    static int[][] dir= {{1,0}, {0,1}, {-1, 0}, {0, -1}}; 
    class Pair{
        int f; 
        int s;
        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for(boolean[] v : vis)Arrays.fill(v, false);

        int maxArea = 0;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(grid[r][c] == 1 && vis[r][c] ==false){
                    int curMax = getMaxAre(r, c, n, m, grid, vis);
                    maxArea = Math.max(curMax, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int getMaxAre(int r, int c, int n, int m, int[][] grid, boolean[][] vis){
        vis[r][c] = true;
        int maxArea = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int curR = p.f;
            int curC = p.s;

            for(int[] d : dir){
                int newR = curR + d[0];
                int newC = curC + d[1];

                if(newR >=0 && newC >=0 && newR < n && newC < m && grid[newR][newC] == 1 && vis[newR][newC] == false){
                    vis[newR][newC] = true;
                    q.add(new Pair(newR, newC));
                    maxArea += 1;
                }
            }
            
        }
        return maxArea;
    }
}