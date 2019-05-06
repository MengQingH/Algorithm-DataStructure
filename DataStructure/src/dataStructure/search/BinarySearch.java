package dataStructure.search;

/**
 * 二分查找
 * 前提：顺序结构、有序排列
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //int e = 6;
        for (int i = 0; i < 11; i++) {
            int index = search(arr, i);
            if (index == -1) {
                System.out.println("查找的元素不存在");
            } else System.out.println(i + "的索引为" + index);
        }

    }

    /**
     * 不使用递归的折半查找
     * 在[low, high]中查找e
     * T(n) = O(log n) S(n) = O(1)
     *
     * @param arr 查找的元素
     * @param e   要查找的元素
     * @return
     */
    public static int search(int[] arr, int e) {
        //指定low和high
        int low = 0;
        int high = arr.length - 1;
        //折半查找
        while (low <= high) {
            //使用+来求mid的值，如果low和high都比较大就有可能会产生数值溢出的问题，所以可以使用减法
            //int mid = (low + high) / 2;
            int mid = low + (high - low) / 2;
            if (arr[mid] == e) {
                return mid;
            }

            //在[mid+1,high]之间查找e
            if (e > arr[mid]) {
                low = mid + 1;
            } else //在[low, mid-1]之间查找e
                high = mid - 1;
        }
        return -1;
    }

    /**
     * 用递归的方式进行折半查找
     * T(n) = O(log n) S(n) = O(log n)
     * @param arr
     * @param e
     * @return
     */
    public static int search_re(int[] arr, int e) {
        //指定low和high
        int low = 0;
        int high = arr.length - 1;
        return search_re(arr, e, low, high);
    }

    public static int search_re(int[] arr, int e, int low, int high) {
        //递归的结束条件
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (e == arr[mid]) {
            return mid;
        } else if (e < arr[mid]) {
            return search_re(arr, e, low, mid - 1);
        } else return search_re(arr, e, mid + 1, high);
    }
}
