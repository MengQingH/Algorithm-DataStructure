package algorithm.sort.selectionSort;

import algorithm.sort.Sort;

/**
 * 选择排序
 */
public class SelectionSort extends Sort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //寻找[i,n)区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int min = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }


    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.testSort();

        selectionSort.testSort(10000);
        selectionSort.testSort(20000);
        selectionSort.testSort(100000);
    }

}
