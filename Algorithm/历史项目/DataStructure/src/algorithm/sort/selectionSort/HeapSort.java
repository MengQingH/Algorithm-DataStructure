package algorithm.sort.selectionSort;

import algorithm.sort.Sort;
import dataStructure.maxHeap.MaxHeap;

/**
 * 堆排序，需要使用到最大堆
 */
public class HeapSort extends Sort {
    /**
     * 使用先创建空最大堆，然后逐个插入数据的方式创建一个最大堆
     *
     * @param arr
     */
    public void sort(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(100);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    /**
     * 堆排序的优化：原地堆排序，除去了开额外的空间和向堆中移动数据的过程，直接在数组中进行操作（索引从0开始）
     * 通过heapify操作把数组变为一个二叉堆，再通过不断交换第一个和二叉堆的最后一个元素，每次交换二叉堆的长度-1，并对第一个元素进行shiftDown的过程来实现排序
     * 虽然时间复杂度和未优化的方法相同，但实际上效率要高
     *
     * @param arr
     */
    public void sort_re(int[] arr) {
        //对数组进行heapify操作，把数组变为一个二叉堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            shiftDown(arr,arr.length,i);
        }
        //把数组最后一个元素和第一个元素交换位置，再对第一个元素进行shiftDown操作把二叉树排列整齐
        for (int i = arr.length - 1; i > 0; i--) {
            int swap = arr[i];
            arr[i] = arr[0];
            arr[0] = swap;
            shiftDown(arr,i,0);
        }
    }

    /**
     * shiftDown操作，把二叉堆数组中某位置的元素不断向下移动，从而使位置正确
     * 与二叉堆中的shiftDown方法类似，不同点是该方法操作的数组索引是从0开始的
     *
     * @param arr
     * @param k
     */
    public void shiftDown(int[] arr,int length, int k) {
        //判断该结点是否有子节点，如果该节点有左结点那么肯定有子节点
        while (2 * k + 1 < length) {

            int j = 2 * k + 1;//在此轮循环中，data[k]和data[j]交换位置
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[k] >= arr[j]) {
                break;
            }
            int swap = arr[k];
            arr[k] = arr[j];
            arr[j] = swap;

            k = j;
        }
    }


    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.testSort();

        heapSort.testSort(10000);
        heapSort.testSort(20000);
        heapSort.testSort(40000);
        heapSort.testSort(80000);

    }

}
