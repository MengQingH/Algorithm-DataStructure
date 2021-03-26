/*
 * @Author: QingHui Meng
 * @Date: 2021-03-26 13:46:16
 */
/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {

    //存放数据流中较大的一半，堆顶元素为这些元素中的最小值（最小堆）
    private PriorityQueue<Integer> large;
    //存放数据流中较小的一半，堆顶元素为这些元素中的最大值（最大堆）
    private PriorityQueue<Integer> small;

    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<>();
        //java中的堆默认为最小堆，如果要创建最大堆需要传入一个Comparator参数
        small = new PriorityQueue<>((a, b) -> b - a);
    }
    
    /**
     * 添加元素时要维护两个堆的特性
     * 
     * @param {int} num
     * @return {*}
     */
    public void addNum(int num) {
        //如果small中的元素个数大于large，就要向large中添加元素
        if(small.size() >= large.size()){
            //添加元素的方式为先把元素添加到small中，再把small中的堆顶元素即最大值添加到large中。
            //这样就保证了两个堆的元素个数差值不超过1，并且large中的数据为较大的一半，small中的数据为较小的一半
            small.offer(num);
            large.offer(small.poll());
        }else{
            //向small中添加元素同理
            large.offer(num);
            small.offer(large.poll());
        }
    }
    
    /**
     * 如果两个堆中的元素个数不同，那么元素为奇数个，多出来的元素为中位数
     * 如果两个堆中的元素个数相同，那么元素为偶数个，两个堆顶元素的平均值为中位数
     * 
     * @param {*}
     * @return {*}
     */
    public double findMedian() {
        if(large.size() > small.size())
            return large.peek();
        if(large.size() < small.size())
            return small.peek();
        return (large.peek() + small.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

