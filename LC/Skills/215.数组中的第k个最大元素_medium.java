/*
 * @Author: QingHui Meng
 * @Date: 2021-04-17 14:42:32
 */
/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {

    /**
     * 快速选择算法：快速排序经过一次递归调用后，元素就会出现在他应该在的位置，
     *   然后可以使用二分查找的思想，找出想要索引的元素
     * 
     * @param {int[]} nums
     * @param {int} k
     * @return {*}
     */
    public int findKthLargest(int[] nums, int k) {
        // 先对数组进行打乱
        shuffle(nums);
        int lo = 0, hi = nums.length-1;
        k = nums.length - k;
        while(lo <= hi){
            // 先对数组进行一次快排的partition操作，找出第p个元素
            int p = partition(nums, lo, hi);
            if(p < k){
                lo = p+1;
            }else if(p > k){
                hi = p-1;
            }else {
                return nums[p];
            }
        }
        return -1;
    }

    // 对数组元素进行随机打乱
    void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0 ; i < n; i++) {
            // 从 i 到最后随机选一个元素
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        // 将 nums[lo] 作为默认分界点 pivot
        int pivot = nums[lo];
        // j = hi + 1 因为 while 中会先执行 --
        int i = lo, j = hi + 1;
        while (true) {
            // 保证 nums[lo..i] 都小于 pivot
            while (nums[++i] < pivot) {
                if (i == hi) break;
            }
            // 保证 nums[j..hi] 都大于 pivot
            while (nums[--j] > pivot) {
                if (j == lo) break;
            }
            if (i >= j) break;
            // 如果走到这里，一定有：
            // nums[i] > pivot && nums[j] < pivot
            // 所以需要交换 nums[i] 和 nums[j]，
            // 保证 nums[lo..i] < pivot < nums[j..hi]
            swap(nums, i, j);
        }
        // 将 pivot 值交换到正确的位置
        swap(nums, j, lo);
        // 现在 nums[lo..j-1] < nums[j] < nums[j+1..hi]
        return j;
    }
    
    // 交换数组中的两个元素
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 思路1：使用二叉堆。把所有元素放入最小堆中，不断弹出到只剩下k个元素，
     * 那么剩下的k个元素就是k个最大元素，而栈顶元素也就是k个元素中最小的。
     * 
     * @param {int[]} nums
     * @param {int} k
     * @return {*}
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
            // 当元素个数大于k时，弹出
            if(pq.size() > k){
                pq.poll();
            }
        }
        // pq中剩下的是数组中最大的k个元素，堆顶是最小的。
        return pq.peek();
    }
}
// @lc code=end

