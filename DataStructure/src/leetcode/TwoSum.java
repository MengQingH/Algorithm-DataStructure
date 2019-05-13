package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * TwoSum：
 * 给定一个整数数组nums和一个目标值target，请你在该整数中找出和为目标值的那两个数，并返回他们的数组下标。
 * 假定每种输入只会对应一个答案，不能重复利用数组中的元素。
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum num = new TwoSum();
        int[] arr = new int[]{2, 7, 11, 34};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(num.twoSum(arr, 9)));
    }

    /**
     * 解题思路：对每一个元素，判断该元素和target值减去该元素的差值是否都在该数组中，如果在，则返回两个值的下标。
     * 保持数组中每个元素和他的索引关系最好的方法就是哈希表。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //创建一个hashMap并把每个元素都放入HashMap中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            //判断数组中是否存在这个差值
            //坑1：应该限定这个差值不应该是当前值，否则当前值为目标值的一半时，将返回两个当前值。
            if (map.containsKey(x)&&map.get(x)!=i) {
                return new int[]{i,map.get(x)};
            }
            //坑2：放入map时，应该把数组的值放在key的位置上，因为最终要返回数组的索引，需要通过值来搜索值在数组中的索引，而map只提供了通过key来获取value的方法
            //坑3：put语句只能放在循环的最后面，如果数组中有两个相邻的元素值相同且都为target值一半，就会发生错误，错过这种情况
            //nums:[3,3] target:6
            map.put(nums[i], i);
        }
        return null;

    }

}
