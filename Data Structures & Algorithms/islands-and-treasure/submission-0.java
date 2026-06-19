class Solution {
    class Pair{
        int f;
        int s;
        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }


    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(boolean[] v : vis) Arrays.fill(v, false);

        for(int r = 0; r<n; r++){
            for(int c =0; c<m; c++){
                if(grid[r][c] == 0 && vis[r][c] == false){
                    q.add(new Pair(r,c));
                    vis[r][c] = true;
                }
            }
        }

        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                Pair p = q.poll();
                int r = p.f;
                int c = p.s;
                grid[r][c] = dist;

           
                findLand(r+1, c, m, n, vis, grid, q);
                findLand(r, c+1, m, n, vis, grid, q);
                findLand(r-1, c, m, n, vis, grid, q);
                findLand(r, c-1, m, n, vis, grid, q);
                size--;
            }
            dist +=1;
        }

    }

    public void findLand(int r, int c, int m, int n, boolean[][] vis, int[][] grid, Queue<Pair> q){
        if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] != -1 && vis[r][c] == false){
            vis[r][c] = true;
            q.add(new Pair(r,c));
        }
    }

}

