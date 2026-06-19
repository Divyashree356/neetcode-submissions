class Solution {
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void dfs(char[][] board,  boolean[][] vis, int i, int j , int n, int m){
        vis[i][j] = true;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];

            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 'O' && vis[r][c] == false) 
                dfs(board, vis, r, c, n, m);
        }

    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m]; 
        for(boolean[] v : vis)Arrays.fill(v, false);

        for(int i = 0; i < m ; i ++){
         if(board[0][i] == 'O' && vis[0][i] == false)  dfs(board, vis, 0, i, n, m);
         if(board[n-1][i] == 'O' && vis[n-1][i] == false) dfs(board, vis, n-1,i,  n, m);   
        }
        
        for(int i = 0; i < n ; i++){
        if(board[i][0] == 'O' && vis[i][0] == false)  dfs(board, vis, i, 0, n, m);
        if(board[i][m-1] == 'O' && vis[i][m-1] == false) dfs(board, vis, i, m-1, n, m);
        }


        for(int i = 0; i < n; i++){
            for(int j= 0; j < m; j++){
                if(board[i][j] == 'O' && vis[i][j] == false)  board[i][j] = 'X';
            }
        }
    }
}