class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int i =0; i < row; i++){
            for(int j =0; j < col; j++){
                if(word.charAt(0) == board[i][j] && wordFound(i, j, row, col, board, word, 0, visited)) return true;
            }
        }
        return false;
    }
    public boolean wordFound(int i, int j ,int r, int c, char[][] board, String word, int curL, boolean[][] visited){
        if(curL == word.length()) return true;

        if(i < 0 || j < 0 || i >= r || j >= c || visited[i][j] == true || word.charAt(curL) != board[i][j]) return false;
        
        visited[i][j] = true;
        if (wordFound(i+1, j, r, c, board, word, curL+1, visited) ||
            wordFound(i, j+1, r, c, board, word, curL+1, visited) ||
            wordFound(i-1, j, r, c, board, word, curL+1, visited) || 
            wordFound(i, j-1, r, c, board, word, curL+1, visited)) return true;

        visited[i][j] = false;
        return false;

    }
}