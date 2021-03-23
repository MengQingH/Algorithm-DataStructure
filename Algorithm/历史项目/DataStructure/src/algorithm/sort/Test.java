package algorithm.sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 6, 7, 3, 4, 2, 0, 8, 2, 5, 9, 10};

        Test t = new Test();
        System.out.println(Arrays.toString(arr));
        t.mergeSort_UB(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
    }

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int swap = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = swap;
                } else break;
            }

        }
    }

    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j])
                    index = j;
            }
            int swap = arr[index];
            arr[index] = arr[i];
            arr[i] = swap;
        }
    }


    public void shellSort(int[] arr) {
        int increment = arr.length;
        while (true) {
            increment = increment / 2;
            for (int i = 0; i < increment; i++) {
                for (int j = i + increment; j < arr.length; j += increment) {
                    for (int k = j; k > i; k -= increment) {
                        if (arr[k] < arr[k - increment]) {
                            int swap = arr[k];
                            arr[k] = arr[k - increment];
                            arr[k - increment] = swap;
                        }
                    }

                }
            }
            if (increment == 1) break;
        }
    }

    public void mergeSort_UB(int[] arr, int l, int r) {
        if (l < r) return;
        int mid = (l + r) / 2;
        mergeSort_UB(arr, l, mid);
        mergeSort_UB(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[arr.length];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
        }
        while (j <= r) {
            temp[k] = arr[j];
            j++;
        }
        k = 0;
        while (k < arr.length) {
            arr[k] = temp[k];
            k++;
        }
    }

    public void mergeSort_BU(int[] arr) {
        for (int size = 1; size <= arr.length; size += size) {
            for (int i = 0; i + size < arr.length; i += 2 * size) {
                int r = arr.length - 1 > i + 2 * size - 1 ? i + 2 * size - 1 : arr.length - 1;
                merge(arr, i, i + size - 1, r);
            }

        }
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l > r) return;

        int index = partition(arr, l, r);
        quickSort(arr, l, index - 1);
        quickSort(arr, index + 1, r);

    }

    private int partition(int[] arr, int l, int r) {
        int i = l;
        int j = r;
        int temp = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= temp)
                j--;
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] <= temp)
                i++;
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        arr[i] = temp;
        return i;
    }

}
