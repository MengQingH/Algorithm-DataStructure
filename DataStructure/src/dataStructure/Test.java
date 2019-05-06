package dataStructure;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] arr1 = new int[]{3, 6, 2, 6, 7, 3, 8, 1};
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));

    }

    public static int binarySearch(int[] arr, int e) {
        int low = 0;
        int high = arr.length - 1;
        int medium;
        while (low <= high) {
            medium = (low + high) / 2;
            if (e == medium) {
                return medium;
            } else if (e > medium) {
                low = medium + 1;
            } else high = medium - 1;
        }
        return -1;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int index = partition(arr, l, r);
            quickSort(arr, index + 1, r);
            quickSort(arr, l, index - 1);
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int i = l;
        int j = r;
        int x = arr[i];
        while (i < j) {
            while (arr[j] > x && i < j)
                j--;
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (arr[i] < x && i < j)
                i++;
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = x;
        return i;
    }

}
