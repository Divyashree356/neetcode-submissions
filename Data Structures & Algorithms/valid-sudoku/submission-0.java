class Solution {
    public boolean isValidSudoku(char[][] board) {


    for (int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            
            if (board[i][j] == '.') continue;
            else {
                int row_left =  i - i%3;
                int row_right  =  row_left +2;
                int column_up = j - j%3;
                int colum_down =  column_up +2;
            
                System.out.println(row_left);
                System.out.println(row_right);
                System.out.println(column_up);
                System.out.println(colum_down);

        
                for(int r = row_left ; r <= row_right; r++){
                    for(int c = column_up; c <= colum_down; c++){
                        
                        if (r != i && c != j && board[r][c] == board[i][j]) return false;
                    }
                }

                for (int c=j+1; c <9; c++){
                    if (board[i][c] == board[i][j]) return false;
                }

                for (int r=i+1; r <9; r++){
                    if (board[r][j] == board[i][j]) return false;
                }
            }
        }
    }
    return true;

    }
}
