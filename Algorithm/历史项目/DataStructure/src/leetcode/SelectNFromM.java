package leetcode;

/**
 * 从n个元素中选择排序后第m个元素
 */
public class SelectNFromM {
    public static void main(String[] args) {
        SelectNFromM s = new SelectNFromM();
        int[] arr = new int[]{9, 7, 3, 1, 2, 6, 4, 5, 8, 10};
        System.out.println(s.select(arr, 5));
    }

    /**
     * 解决思路：类似快速排序。当完成一次partition操作之后，如果返回的值大于要选择的次序就对左半序列进行递归，
     * 如果返回的值小于要选择的次序就对右半序列进行递归，直到partition返回值和要求的序列值相同。
     *
     * @param arr
     * @param e
     * @return
     */
    public int select(int[] arr, int e) {
        return quickSort(arr, 0, arr.length - 1, e);
    }

    private int quickSort(int[] arr, int l, int r, int e) {
        if (l < r) {
            int mid = partition(arr, l, r);
            if (mid == e) {
                return arr[mid];
            } else if (mid > e) {
                return quickSort(arr, l, mid - 1, e);
            } else return quickSort(arr, mid + 1, r, e);
        } else return -1;

    }

    private int partition(int[] arr, int l, int r) {
        int i = l;
        int j = r;
        int e = arr[l];

        while (i < j) {
            while (i < j && arr[j] >= e) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] <= e) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = e;
        return i;

    }

}
