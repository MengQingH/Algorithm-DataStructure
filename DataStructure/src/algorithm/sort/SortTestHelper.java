package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class SortTestHelper {
    /**
     * 生成n个元素的随机数组，每个元素的范围在[rangeL,rangeR]之间
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        if (rangeL > rangeR) {
            return null;
        }
        int[] arr = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    /**
     * 判断数组是否正确排序
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length -1; i++) {
            if (arr[i]>arr[i+1])return false;
        }
        return true;
    }
}
