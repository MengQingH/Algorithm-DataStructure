package algorithm.sort;

import java.util.Arrays;

public class Sort {
    public void sort(int[] arr) {

    }

    /**
     * 测试排序算法消耗的时间
     * @param n
     */
    public void testSort(int n) {
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("算法数量级：" + n + "   消耗的时间：" + (double) (end - start) / 1000 + "s");
    }

    /**
     * 测试是否可以正确排序
     */
    public void testSort(){
        int[] arr = SortTestHelper.generateRandomArray(10, 0, 10);
        System.out.println("排序前："+Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }
}
