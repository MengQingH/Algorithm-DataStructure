package algorithm.sort.exchangeSort;

import algorithm.sort.Sort;

import java.util.Random;

/**
 * 快速排序(一下三种方式的分区操作不同，但是都可以进行随机化优化)：
 * 普通快速排序
 * 双路快速排序
 * 三路快速排序
 */
public class QuickSort extends Sort {

    /**
     * 对arr[l...r]部分进行快速排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private void quickSort(int[] arr, int l, int r) {
        /**
         * 优化：当数据量比较小的时候，可以使用插入排序方式进行排序，效率有所提高
         */
        if (r - l <= 15) {
            //使用插入排序的方式进行排序，并返回
        }
        if (l < r) {
            //对数组进行分区，并返回分区中点的坐标
            int index = partition(arr, l, r);
            //对左右两个分区进行递归操作，继续进行分区
            quickSort(arr, index + 1, r);
            quickSort(arr, l, index - 1);
        }
    }

    /**
     * 普通快速排序的分区操作：分区从序列的一段开始进行，到另一端结束，把小于基准值的元素放在左边，大于基准值的元素放在右边。
     * 从一端进行遍历操作，相当于单路
     * 对数组进行分区，使得arr[i...index-1]<arr[index] arr[index+1...r]>arr[index]
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] arr, int l, int r) {
        //把序列第一个值作为基准值
        int re = arr[l];
        //j表示j及j之前坐标的元素是小于基准值的数
        int j = l;
        //i表示对整个序列进行遍历
        for (int i = l; i <= r; i++) {
            //当有小于基准值的元素出现时，应该把这个值与j的后一个元素交换，并把j++
            if (arr[i] < re) {
                int swap = arr[j + 1];
                arr[j + 1] = arr[i];
                arr[i] = swap;
                j++;
            }
        }
        //整个数组遍历完时，j及j之前的元素全小于基准值，后面的元素全大于基准值
        //把j和基准值交换，这样j前面的元素全都小于j，j后面的元素全都大于j
        int swap = arr[l];
        arr[l] = arr[j];
        arr[j] = swap;

        //返回基准值的坐标
        return j;
    }

    /**
     * 双路快速排序的分区：序列中的值与基准值的比较从两端同时开始进行
     * 对数组进行分区，使得arr[i...index-1]<arr[index] arr[index+1...r]>arr[index]
     *
     * @param arr
     * @param l
     * @param r
     * @return index
     */
    private int partition_2(int[] arr, int l, int r) {

        /**
         * 当序列近乎有序时，快速排序的效率会非常低，此时可以随机选择基准值的方法进行优化
         */
//        Random random= new Random();
//        int x = random.nextInt(r-l)+l;
//        int swap = arr[x];
//        arr[x] = arr[l];
//        arr[l] = swap;

        //定义左指针和右指针
        int i = l;
        int j = r;
        //将第一个数作为基数
        int re = arr[i];
        while (i < j) {
            //从右向左移动右指针，直到找到一个小于基准值的数
            while (i < j && arr[j] >= re) {
                j--;
            }
            //把找到的数赋值给左指针处的值，左指针向右移动
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            //从左向右移动左指针，直到找到一个大于基准值的数
            while (i < j && arr[i] <= re) {
                i++;
            }
            //把找到的数赋值给右指针的处的值，右指针向左移动
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        //把基准值赋值给最后的位置
        arr[i] = re;
        //返回基准值当前的位置
        return i;
    }


    /**
     * 三路快速排序：从序列的一端开始遍历直到另一端
     * 把序列分为小于、大于、等于基准值三个区域
     * 三路快速排序与前两个都有partition函数不同的是三路排序完成后需要对小于和大于基准值的序列进行递归操作，这两个值不相同，所以不能封装partition函数
     *
     * @param arr
     * @param l
     * @param r
     */
    public void quickSort_3(int[] arr, int l, int r) {

        if (l >= r) return;

        //以第一个元素为基准值
        int re = arr[l];

        //arr[l+1...lt]<re 遍历过程lt及lt左边的元素都小于基准值，遍历结束后，lt位置上的值和基准值交换，就变成lt左边的元素小于基准值
        int lt = l;
        //arr[gt...r]>re gt及gt右边的元素大于re
        int gt = r + 1;
        //arr[lt+1...i)==re 用i遍历整个序列，i处的值为待处理的值。遍历过程中lt+1到i-1处的值都等于基准值，遍历结束lt到i-1之间的值等于基准值
        int i = l + 1;

        while (i < gt) {
            //当i处的值小于基准值时，把lt右边lt+1处即第一个等于基准值的值和i处的值交换，i和lt的位置都向右一位
            if (arr[i] < re) {
                int swap = arr[i];
                arr[i] = arr[lt + 1];
                arr[lt + 1] = swap;
                lt++;
                i++;
            }
            //当i处的值大于基准值时，把gt左边的值与i处的值交换，并把gt向左一位
            else if (arr[i] > re) {
                int swap = arr[i];
                arr[i] = arr[gt - 1];
                arr[gt - 1] = swap;
                gt--;
            }
            //当i处的值等于基准值时，i向右一位
            else i++;
        }

        //最后把lt处的值和基准值交换，这样lt左边的值全小于基准值，不包括lt
        int swap = arr[l];
        arr[l] = arr[lt];
        arr[lt] = swap;

        //对大于小于基准值的部分进行递归操作
        quickSort_3(arr, l, lt - 1);
        quickSort_3(arr, gt, r);

    }

    @Override
    public void sort(int[] arr) {
        quickSort_3(arr, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.testSort();

        quickSort.testSort(10000);
        quickSort.testSort(20000);
        quickSort.testSort(40000);
    }
}
