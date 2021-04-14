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
        //
        if(row == board.length)
            return;
        //到达行末
        if(col == board.length){
            backtrack(board, row+1, 0);
        }

        if(board[row][col] != '.'){
            backtrack(board, row, col+1);
        }
        for(int i = 1; i<10; i++){
            //做选择
            board[row][col] = (char)i;
            //递归
            if(isValid(board, row, col)){
                backtrack(board, row, col+1);
            }
            //撤回选择
            board[row][col] = '.';
        } 
    }

    private boolean isValid(char[][] board, int row, int col){
        int rowStart = row/3 *3;
        int colStart = col/3 *3;
        for(int i = rowStart; i<rowStart+3; i++){
            for(int j = colStart; j<colStart+3; j++){
                if(i == row && j == col)
                    continue;
                if(board[i][j] == board[row][col])
                    return false;
            }
        }

        for(int i = 0; i<board.length; i++){
            if(i == row || i == col)
                continue;
            if(board[i][col] == board[row][col])
                return false;
            if(board[row][i] == board[row][col])
                return false;
        }

        return true;
    }
}
// @lc code=end

