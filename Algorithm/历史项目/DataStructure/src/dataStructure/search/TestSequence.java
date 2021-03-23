package dataStructure.search;

/**
 * 顺序查找
 * 时间复杂度为：T(n) = O(n)
 */
public class TestSequence {
    public static void main(String[] args) {
        //给定查找序列
        int[] arr = {89, 45, 78, 100, 98, 86, 100, 65};

        //给定要查找的元素
        int e = 100;

        //完成查找
        int index = search(arr, e);

        //输出结果
        if (index == -1) {
            System.out.println("查找的元素不存在");
        } else System.out.println("查找的元素索引为" + index);
    }

    public static int search(int[] arr, int e) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                index = i;
                break;
            }
        }
        return index;
    }
}
