package algorithm.sort.mergeSort;

import algorithm.sort.Sort;

/**
 * 自底向上的归并排序
 * 有一个重要的性质就是在排序的过程中没有通过下标直接获取元素，所以可以对链表进行排序。
 */
public class MergeSort_BU extends Sort {
    @Override
    public void sort(int[] arr) {
        //size表示每次归并的子序列的个数，第一次为1，之后每次加倍
        for (int size = 1; size <= arr.length; size += size) {
            //i表示每一次归并过程元素的位置，i+size-1表示中点坐标，i+2*size-1表示最后一个元素
            //所以每次i需要跳跃2size个距离，对下一段序列进行归并
            for (int i = 0; i + size < arr.length; i += size * 2) {
                //对arr[i...i+size-1]和arr[i+size...i+2*size-1]进行归并
                /**
                 * //此时有可能出现越界问题，需要限定：
                 * 1.i+size有可能越界，在循环条件处限定
                 * 2.i+2*size-1有可能越界，此时可以依然进行归并，只不过后一个序列数量小于前一个序列，
                 * 可以使用i+2*size-1或arr.length-1中的小值
                 */
                //判断i+2size-1是否越界
                int r =  (i + 2 * size - 1) < (arr.length - 1) ? (i + 2 * size - 1) : (arr.length - 1);
                merge(arr, i, i + size - 1, r);
            }

        }
    }

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
    }

    public static void main(String[] args) {
        MergeSort_BU mergeSort_bu = new MergeSort_BU();
        mergeSort_bu.testSort();

        mergeSort_bu.testSort(10000);
        mergeSort_bu.testSort(20000);
        mergeSort_bu.testSort(40000);
    }

}
