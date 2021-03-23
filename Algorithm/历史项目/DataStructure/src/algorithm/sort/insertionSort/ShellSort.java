package algorithm.sort.insertionSort;

import algorithm.sort.Sort;

/**
 * 希尔排序
 */
public class ShellSort extends Sort {
    public void sort(int[] arr) {
        int increment = arr.length;
        while (true) {
            //定义子序列的个数，第一次为数组长度的一半
            increment = increment / 2;
            //对每一个子序列进行遍历，子序列中的值为[k, k+increment, k+2*increment ...]
            for (int k = 0; k < increment; k++) {
                //对每个子序列进行直接插入排序
                for (int i = k + increment; i < arr.length; i += increment) {
                    for (int j = i; j > k; j -= increment) {
                        if (arr[j] < arr[j - increment]) {
                            int temp = arr[j];
                            arr[j] = arr[j - increment];
                            arr[j - increment] = temp;
                        } else break;
                    }
                }
            }
            //当子序列的增量为1，即子序列为整个序列的时候停止
            if (increment == 1) break;
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.testSort();

        shellSort.testSort(10000);
        shellSort.testSort(20000);
        shellSort.testSort(40000);
        shellSort.testSort(80000);
        shellSort.testSort(160000);
    }
}
