class Solution {
    class Pair{
        int f;
        int s;

        public Pair(int f,int s){
            this.f = f;
            this.s = s;
        }

    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for(boolean[] v  : vis) Arrays.fill(v, false);

        Queue<Pair> q= new LinkedList<>();

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 2 && vis[r][c] == false){
                    vis[r][c] = true;
                    q.add(new Pair(r, c));
                }
            }
        }

        
        int curMin = -1;
        while(!q.isEmpty()){
            int size = q.size();
            curMin +=1;
            while(size > 0){
                Pair p = q.poll();
                int r = p.f;
                int c = p.s;

                grid[r][c] = 2;
                
                getFreshOrange(vis, grid, r+1, c, n, m, q);
                getFreshOrange(vis, grid, r, c+1, n, m, q);
                getFreshOrange(vis, grid, r-1, c, n, m, q);
                getFreshOrange(vis, grid, r, c-1, n, m, q);
                size--;

            }
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 1)return -1;
            }
        }
        return curMin == -1 ? 0 : curMin;

    }

    public void getFreshOrange( boolean[][] vis, int[][] grid, int r, int c, int n, int m, Queue<Pair> q){
        if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1 && vis[r][c] == false){
            vis[r][c] = true;
            q.add(new Pair(r,c));
        }
    }
}