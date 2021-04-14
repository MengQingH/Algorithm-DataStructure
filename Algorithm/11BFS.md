<!--
 * @Author: QingHui Meng
 * @Date: 2021-04-13 19:54:24
-->
BFS的常见场景，在一幅图中找到起点start到终点target的最近距离。

BFS类似于层次遍历，每前进一次，从根节点向外扩展一层，这就可以保证在第一次到达终点时，走的步数是最小的。并且可以在不遍历完整棵树的条件下找到最短距离。

而DFS是依靠递归的堆栈记录走过的路径，如果要找到最短距离，肯定要把二叉树中所有的树杈都探索玩才能对比出最短的路径。

## 框架
```java
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路

    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数

    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加入队列 */
            for (Node x : cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
        }
        /* 划重点：更新步数在这里 */
        step++;
    }
}
```

## 二叉树的最小高度
Lc111 

## 打开轮盘锁
Lc752.

## 双向BFS优化
传统的BFS时从起点开始向四周扩散，遇到终点时停止，而双向BFS则是从起点和终点同时开始扩散，当两边有交集时停止。