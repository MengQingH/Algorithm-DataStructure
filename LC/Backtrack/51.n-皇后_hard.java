/*
 * @Author: QingHui Meng
 * @Date: 2021-04-12 10:59:50
 */
/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<char[]> board = new ArrayList<>();
        
        //初始化
        for(int i = 0; i<n; i++){
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            board.add(arr);
        }

        backtrack(board, 0);
        return res;
    }

    /**
     * 使用回溯获取所有结果
     * 
     * @param {List<char[]>} board
     * @param {int} row
     * @return {*}
     */
    private void backtrack(List<char[]> board, int row){
        //结束条件
        if(row == board.size()){
            res.add(transform(board));
        }

        int n = board.size();
        for(int col = 0; col<n; col++){// 遍历所有选择
            //剪枝，检查该位置是否符合条件
            if(!isValid(board, row, col)){
                continue;
            }
            board.get(row)[col] = 'Q';//做选择
            backtrack(board, row+1);//进入下一行决策
            board.get(row)[col] = '.';//撤回选择
        }
    }

    /**
     * 检查行列分别为row，col的位置是否有皇后冲突
     * 
     * @param {List<char[]>} board
     * @param {int} row
     * @param {int} col
     * @return {*}
     */
    private boolean isValid(List<char[]> board, int row, int col){
        int n = board.size();

        //检查列是否有皇后相互冲突
        for(int i = 0; i<n; i++){
            if(board.get(i)[col] == 'Q')
                return false;
        }

        //检查左上是否有皇后相互冲突
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--,j--){
            if(board.get(i)[j] == 'Q')
                return false;
        }

        //检查右上是否有皇后相互冲突
        for(int i = row-1, j = col+1; i >= 0 && j < n; i--,j++){
            if(board.get(i)[j] == 'Q')
                return false;
        }
        return true;
    }

    /**
     * 结果的格式转换
     * 
     * @param {List<char[]>} board
     * @return {*}
     */
    private List<String> transform(List<char[]> board){
        List<String> newBoard = new ArrayList<>();
        for(char[] row : board){
            newBoard.add(new String(row));
        }
        return newBoard;
    }
}
// @lc code=end

