class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board= new char[n][n];
        for(char[] c : board){
            Arrays.fill(c, '.');
        }

        solve(n, 0, board, ans);
        return ans;

    }

    public void solve(int n, int j, char[][] board, List<List<String>> ans) {
        if (j == n)
            ans.add(getOp(board, n));

        for (int i = 0; i < n; i++) {
           if(queenInDir(board, i, j, n)){
            board[i][j] = 'Q';
            solve(n, j+1, board, ans);
            board[i][j] = '.';
           }
        }
    }

    public boolean queenInDir(char[][] board, int expR, int expC, int n) {
        if(expR >= n || expC >= n || expR < 0 || expC < 0) return false;

        //checking same row backwards
        int i = expR;
        while(i >= 0){
            if (board[expR][i] == 'Q') return false;
            i--;
        }

        //checking same row forward
        i = expR;
        while(i < n) {
            if (board[expR][i] == 'Q') return false;
            i++;
        }

        //checking same column upward
        int j = expC;
        while(j >= 0) {
            // System.out.println(j);
            // System.out.println(expC);
            if (board[j][expC] == 'Q')return false;
            j--;
        }
        
        j = expC;
        while (j < n) {
            if (board[j][expC] == 'Q') return false;
            j++;
        }

        //checking left diag upwards
        i = expR;
        j = expC;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        i = expR;
        j = expC;
        // checkin right downwards
        while (i < n && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j++;
        }

        i = expR;
        j = expC;

        //left downwards
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        i = expR;
        j = expC;

        //right upwards
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }

    public List<String> getOp(char[][] board, int n){
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                for(int j = 0; j <n; j++){
                    sb.append(board[i][j]);
                }
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
            return ans;
    }
}