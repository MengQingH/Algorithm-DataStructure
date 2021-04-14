/*
 * @Author: QingHui Meng
 * @Date: 2021-04-13 20:16:23
 */
/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {

    /**
     * 双向BFS优化
     * 
     * @param {String[]} deadends
     * @param {String} target
     * @return {*}
     */
    public int openLock(String[] deadends, String target){
        Set<String> deadendsSet = new HashSet<>();
        for(String s : deadends){
            deadendsSet.add(s);
        }
        //这里可以用集合不用队列，但是由于集合无序，需要做额外的限制
        Set<String> queue1 = new HashSet<>();
        Set<String> queue2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        //初始化根节点 和 终点
        int step = 0;
        queue1.add("0000");
        queue2.add(target);

        while(!queue1.isEmpty() && !queue2.isEmpty()){
            //由于使用的是哈希集合而不是队列，遍历过程中不能变，需要一个数据结构存储扩散的结果
            Set<String> temp = new HashSet<>();

            //把queue1中的节点向外扩散
            for(String cur : queue1){
                if(deadendsSet.contains(cur))
                    continue;
                //判断是否到达终点
                if(queue2.contains(cur))
                    return step;
                visited.add(cur);

                //cur的扩散结果
                for(int j = 0; j<4; j++){
                    String plus = plusNum(cur, j);
                    if(!visited.contains(plus))
                        temp.add(plus);
                    String minis = minisNum(cur, j);
                    if(!visited.contains(minis))
                        temp.add(minis);
                }
            }
            step++;
            //temp相当于queue1，这里queue1和queue2互换，下一轮扩散queue2
            queue1 = queue2;
            queue2 = temp;
        }
        return -1;
    }

    /**
     * BSF算法解决问题，关键是如何把题目中的问题抽象成图：
     *  如果只转动一下锁，锁中有四个位置，每个位置可以向上转，也可以向下转，总共有八种可能；
     * 每种情况又可以重新向外扩展，这样就可以抽象成一幅图，每个节点有八个相邻的节点，
     * 最后再加上要求最短距离，就是典型的BSF算法。
     * 
     * 
     * @param {String[]} deadends
     * @param {String} target
     * @return {*}
     */
    public int openLock1(String[] deadends, String target) {

        List<String> deadendsList = Arrays.stream(deadends).collect(Collectors.toList());

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        //初始化根节点
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        //BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            //遍历更外一层的节点
            for(int i = 0; i<size; i++){
                String cur = queue.poll();

                //判断是否到达终点
                if(cur.equals(target))
                    return step;
                if(deadendsList.contains(cur))
                    continue;

                //把外面一层的相邻节点加入队列
                for(int j = 0; j<cur.length(); j++){
                    String plus = plusNum(cur, j);
                    if(!visited.contains(plus)){
                        queue.offer(plus);
                        visited.add(plus);
                    }

                    String minis = minisNum(cur, j);
                    if(!visited.contains(minis)){
                        queue.offer(minis);
                        visited.add(minis);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 向上拨动index位上的数字
     * 
     * @param {*}
     * @return {*}
     */
    private String plusNum(String s, int index){
        char[] chars = s.toCharArray();
        if(chars[index] == '9')
            chars[index] = '0';
        else chars[index] += 1;
        return new String(chars);
    }

    /**
     * 向下拨动index位上的数字
     * 
     * @param {*}
     * @return {*}
     */
    private String minisNum(String s, int index){
        char[] chars = s.toCharArray();
        if(chars[index] == '0')
            chars[index] = '9';
        else chars[index] -= 1;
        return new String(chars);
    }
}
// @lc code=end

