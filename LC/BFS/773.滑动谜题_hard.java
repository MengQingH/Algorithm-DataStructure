/*
 * @Author: QingHui Meng
 * @Date: 2021-04-15 16:58:19
 */
/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 */

// @lc code=start
class Solution {

    /**
     * 双向BFS优化
     * 
     * @param {int[][]} board
     * @return {*}
     */
    public int slidingPuzzle(int[][] board) {
        int m = 2;
        int n = 3;
        // 节点和可以与该节点交换位置的节点之间的映射关系
        int[][] neighbor = new int[][]{
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}
        };
        // 生成初始化字符串和目标字符串
        String target = "123450";
        String start = "";
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                start = start + board[i][j];
            }
        }
 
        // BSF算法
        Set<String> queue1 = new HashSet<>();
        Set<String> queue2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        queue1.add(start);
        queue2.add(target);
        visited.add(start);
        while(!queue1.isEmpty()){
            Set<String> temp = new HashSet<>();
            for(String cur : queue1){
                if(queue2.contains(cur))
                    return step;
                //注意普通BFS和双向BFS把节点加入visited中的位置不同
                visited.add(cur);
                int index = cur.indexOf('0');
                for(int newIndex : neighbor[index]){
                    String newStr = swap(cur, newIndex, index);
                    if(!visited.contains(newStr)){
                        temp.add(newStr);
                    }
                }
            }
            step++;
            queue1 = queue2;
            queue2 = temp;
        }
        return -1;
    }

    /**
     * 对于数字序列的一种状态，每一种移动方式就是当前状态的子局面
     * 序列可以压缩成一个字符串，方便判断，但是由于序列有固定的位置，所以需要列出
     * 每一个节点的可以移动的节点
     * 
     * @param {int[][]} board
     * @return {*}
     */
    public int slidingPuzzle1(int[][] board) {
        int m = 2;
        int n = 3;
        // 节点和可以与该节点交换位置的节点之间的映射关系
        int[][] neighbor = new int[][]{
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}
        };
        // 生成初始化字符串和目标字符串
        String target = "123450";
        String start = "";
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                start = start + board[i][j];
            }
        }
 
        // BSF算法
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                String cur = queue.poll();
                if(cur.equals(target))
                    return step;
                int index = cur.indexOf('0');
                for(int newIndex : neighbor[index]){
                    String newStr = swap(cur, newIndex, index);
                    if(!visited.contains(newStr)){
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 交换字符串中的两个字符
     * 
     * @param {*}
     * @return {*}
     */
    private String swap(String s, int i, int j){
        StringBuffer sb = new StringBuffer(s);
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
        return sb.toString();
    }
}
// @lc code=end

