/*
 * @Author: QingHui Meng
 * @Date: 2021-04-12 16:17:08
 */
/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private void backtrack(char[][] board, int row, int col){
        if(row == board.length || col == board.length)
            return;
        if(board[row][col] != '.'){
            if(col == board.length-1)
                backtrack(board, row+1, 0);
            else backtrack(board, row, col+1);
        }
        for(int i = 1; i<10; i++){
            //做选择
            board[row][col] = (char)i;
            if(isValid(board, row, col)){
                if(col == board.length-1)
                    backtrack(board, row+1, 0);
                else backtrack(board, row, col+1);
            }
            board[row][col] = '.';
        } 
    }

    private boolean isValid(char[][] board, int row, int col){
        int i = row/3 *3;
        int j = col/3 *3;
        for( ; i<i+3; i++){
            for( ; j<j+3; j++){
                if(i == row && j == col)
                    continue;
                if(board[i][j] == board[row][col])
                    return false;
            }
        }

        for(int r = 0; r<board.length; r++){
            if(r == row)
                continue;
            if(board[r][col] == board[row][col])
                return false;
        }
        
        for(int c = 0; c<board.length; c++){
            if(c == col)
                continue;
            if(board[row][c] == board[row][col])
                return false;
        }

        return true;
    }
}
// @lc code=end

