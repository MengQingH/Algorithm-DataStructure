/*
 * @Author: QingHui Meng
 * @Date: 2021-03-30 10:12:33
 */
/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    //入队列保存的栈，出栈顺序和出队列顺序相反
    private Deque<Integer> stack1;
    //存放出队列的数据，出栈顺序就是出队列的顺序
    private Deque<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    /**
     * 入队列的值都先存入stack1中
     * 
     * @param {*}
     * @return {*}
     */
    public void push(int x) {
        stack1.push(x);
    }
    
    /**
     * 
     * 
     * @param {*}
     * @return {*}
     */
    public int pop() {
        peek();
        return stack2.pop();
    }
    
    /**
     * peek时，先把stack1中的数据全部放入stack2，stack2中就是要出队列的序列
     * 如果再有数据入队，那么就继续存入stack1，stack2中的数据全都是早于stack1中的，
     * 所以之后入队只需要存入stack1，出队弹出stack2，不需要来回存数据
     * 只在stack2为空时再次把stack1中的数据塞入即可。
     * 
     * @param {*}
     * @return {*}
     */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

