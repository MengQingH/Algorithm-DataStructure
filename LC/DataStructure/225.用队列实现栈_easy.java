/*
 * @Author: QingHui Meng
 * @Date: 2021-03-31 10:11:43
 */
/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {

    private Queue<Integer> queue;
    //peek或者pop时，需要遍历一遍数据找出出栈元素，所以为了减少复杂度，可以设置一个栈顶元素，这样peek时就不需要遍历元素了
    private Integer top;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /**
     * 栈先进先出，所以需要设置最后入栈的元素为栈顶元素
     * 
     * @param {*}
     * @return {*}
     */
    public void push(int x) {
        queue.offer(x);
        top = x;
    }
    
    /**
     * 出栈不但需要弹出栈顶元素，还需要设置栈顶元素topElement
     * 
     * @param {*}
     * @return {*}
     */
    public int pop() {
        int size = queue.size();
        //先留下队尾两个元素
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        // 记录新的队尾元素
        top = queue.peek();
        queue.offer(queue.poll());
        // 删除之前的队尾元素
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

