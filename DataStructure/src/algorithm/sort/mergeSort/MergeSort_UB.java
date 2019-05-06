package algorithm.sort.mergeSort;

import algorithm.sort.Sort;

/**
 * 自顶向下的归并排序
 */
public class MergeSort_UB extends Sort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用归并排序，对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private void sort(int[] arr, int l, int r) {

        if (l >= r) return;
        /**
         * 优化：当数据量比较小的时候，可以使用插入排序方式进行排序，效率有所提高
         */
        if (r - l <= 15) {
            //使用插入排序方式进行排序
        }

        int mid = (r + l) / 2;
        sort(arr, mid + 1, r);
        sort(arr, l, mid);
        merge(arr, l, mid, r);
        /**
         * 优化：当数据近乎有序时，可以先判断需要归并的两个序列是否已经有序，是的话就可以不进行merge操作
         */
//        if (arr[mid]>arr[mid+1])
//            merge(arr, l, mid, r);

    }


    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private void merge(int[] arr, int l, int mid, int r) {
        //新建一个数组，存放排好序的数组
        int[] aux = new int[r - l + 1];
        //把数组中的内容排序并放入新数组中
        int i = l;
        int j = mid + 1;
        int t = 0;
        //判断两部分子序列的大小，并放入新数组中
        while (i <= mid && j <= r) {
            if (arr[i] > arr[j]) {
                aux[t++] = arr[j++];
            } else {
                aux[t++] = arr[i++];
            }
        }
        //当左右序列有一个全部放完时，直接把另一个依次放入
        while (i <= mid) {
            aux[t++] = arr[i++];
        }
        while (j <= r) {
            aux[t++] = arr[j++];
        }
        //最后把排好序的新数组赋值到原来的数组
        t = 0;
        while (l <= r) {
            arr[l++] = aux[t++];
        }

//        int[] aux = new int[r - l + 1];
//        //把数组中的内容排序
//        int i = l;
//        int j = mid + 1;
//        for (int k = l; k <= r; k++) {
//            if (i > mid) {
//                arr[k] = aux[j - l];
//                j++;
//            } else if (j > r) {
//                arr[k] = aux[i - l];
//                i++;
//            } else if (aux[i - l] < aux[j - l]) {
//                arr[k] = aux[i - l];
//                i++;
//            } else {
//                arr[k] = aux[j - l];
//                j++;
//            }
//        }
    }

    public static void main(String[] args) {
        MergeSort_UB mergeSort_ub = new MergeSort_UB();
        mergeSort_ub.testSort();

        mergeSort_ub.testSort(10000);
        mergeSort_ub.testSort(20000);
        mergeSort_ub.testSort(40000);
        mergeSort_ub.testSort(80000);
    }
}
