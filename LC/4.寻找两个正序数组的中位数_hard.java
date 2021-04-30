/*
 * @Author: QingHui Meng
 * @Date: 2021-04-29 16:57:29
 */
/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {

    /**
     * 如果使用归并的方法求中位数，那么时间复杂度就是O(m+n)；
     * 如果要达到时间复杂度为O(log m+n)，就要使用二分查找的思路：
     *  由于中位数是数组中中间的元素，这个问题也可以转为查找数组中第k个元素，取两个数组中
     * 第k/2个元素进行比较，如果数组1的元素小于数组2的元素，则说明数组1中的前k/2个元素不可能成为第k个元素的候选，
     * 所以将数组1中的前k/2个元素去掉，组成新数组和数组2求第k-k/2小的元素，因为去掉了2/k个元素，所以相应的k值也要减小
     * 
     * @param {int[]} nums1
     * @param {int[]} nums2
     * @return {*}
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totolLen = (len1 + len2)/2;
        if(totolLen%2 == 1){
            double mid = getKthElement(nums1, nums2, totolLen/2+1);
            return mid;
        }else{
            double mid = (getKthElement(nums1, nums2, totolLen/2) + getKthElement(nums1, nums2, totolLen/2+1))/2;
            return mid;
        }
    }

    /**
     * 找出第k小的元素
     * 
     * @param {int[]} nums1
     * @param {int[]} nums2
     * @param {int} k
     * @return {*}
     */
    public int getKthElement(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while(true){
            // 边界情况1：如果nums1查找结束没有找到中位数，直接取nums2的值
            if(index1 == len1){
                return nums2[index2 + k - 1];
            }
            // 边界情况2：如果nums2查找结束没有找到中位数
            if(index2 == len2){
                return nums1[index1 + k -1];
            }
            // 如果k等于1，直接取开始位置中较小的一个
            if(k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }
            // 正常情况
            int half = k/2;
            int newIndex1 = Math.min(index1 + half, len1)-1;
            int newIndex2 = Math.min(index2 + half, len2)-1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k-= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


}
// @lc code=end

