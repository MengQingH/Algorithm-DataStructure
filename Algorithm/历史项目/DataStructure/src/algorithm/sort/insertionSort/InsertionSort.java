package algorithm.sort.insertionSort;

import algorithm.sort.Sort;
import algorithm.sort.SortTestHelper;

/**
 * 插入排序
 */
public class InsertionSort extends Sort {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //寻找元素arr[i]合适的插入位置
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int swap = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = swap;
                }else break;
            }
        }
    }

    /**
     * 改进后的插入排序方法，中间查找元素的位置时不再一直向前交换找到正确的位置，
     * 而是先判断是否是正确位置，不是的话向后移动，最后找到正确的位置再进行赋值，效率有所提高
     * @param arr
     */
    public void sort_im(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            int j;//元素e应该保存的位置
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > e)
                    arr[j] = arr[j-1];
                else break;
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertSort = new InsertionSort();
        insertSort.testSort();

        int[] arr1 = SortTestHelper.generateRandomArray(10000, 0, 10000);
        long start = System.currentTimeMillis();
        insertSort.sort_im(arr1);
        long end = System.currentTimeMillis();
        System.out.println("改进后的插入排序：算法数量级：10000   消耗的时间：" + (double) (end - start) / 1000 + "s");

        insertSort.testSort(10000);
        insertSort.testSort(20000);
        insertSort.testSort(40000);
        insertSort.testSort(80000);
    }
}
