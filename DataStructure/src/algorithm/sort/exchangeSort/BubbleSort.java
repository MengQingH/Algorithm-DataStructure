package algorithm.sort.exchangeSort;

import algorithm.sort.Sort;

/**
 * 冒泡排序
 */
public class BubbleSort extends Sort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                //把相邻的两个数中较大的向后移
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.testSort();

        bubbleSort.testSort(10000);
        bubbleSort.testSort(20000);

    }


}
