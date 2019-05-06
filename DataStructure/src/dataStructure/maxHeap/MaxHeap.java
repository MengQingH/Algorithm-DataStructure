package dataStructure.maxHeap;

import dataStructure.arrayList.List;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/**
 * 最大堆的实现
 */
public class MaxHeap {

    //存放堆中的数据
    private int[] data;
    //堆中数据的个数
    private int size;
    //堆中可以存放的数据个数。capacity相当于一般数组中的arr.length，不过arr.length是[0,arr.length-1]，capacity是[1,capacity]
    private int capacity;

    /**
     * 构造函数，根据指定的长度创建二叉堆，由于存放二叉堆是从1开始的，所以初始化时长度要+1
     * 使用这种方式创建一个二叉堆并把n个元素插入到空堆中，算法复杂度为O(nlogn)
     *
     * @param capacity 指定数组的长度
     */
    public MaxHeap(int capacity) {
        data = new int[capacity + 1];
        size = 0;
        this.capacity = capacity;
    }

    /**
     * Heapify：传入一个数组，根据这个数组中的内容创建一个二叉堆
     * 使用创建一个n个元素的二叉堆，算法复杂度为O(n)
     *
     * @param arr
     */
    public MaxHeap(int[] arr) {
        //根据数组的长度创建二叉堆
        data = new int[arr.length+1];
        //把数组中的元素赋值给二叉堆
        for (int i = 0; i < arr.length; i++) {
            data[i+1] = arr[i];
        }
        size = arr.length;

        //最下面一层的叶子结点可以看作是一个正确的二叉堆
        //可以从最后一个非叶子节点的结点开始逐渐向上进行遍历，对每个元素进行shiftDown操作
        for (int i = size/2; i >= 1; i--) {
            shiftDown(i);
        }

    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二叉堆中添加一个元素，并把该元素放到合适的位置
     *
     * @param e
     */
    public void insert(int e) {
        //空间不足时进行扩容
        //由于数组是从1开始的，所以初始化数组的时候数组的长度为capacity+1。扩容数组时也应该加倍capacity，初始化时长度capacity+1
        if (size+1> capacity) {
            capacity = capacity*2;
            data = Arrays.copyOf(data, capacity+1);
        }
        //把插入的元素放在最后并进行shiftUp操作
        data[size + 1] = e;
        size++;
        shiftUp(size);
    }

    /**
     * 把添加的元素放到合适的位置：不断和该节点的父节点比较，如果大于父节点，就交换两个结点
     *
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2] < data[k]) {
            int swap = data[k / 2];
            data[k / 2] = data[k];
            data[k] = swap;

            k = k / 2;
        }
    }


    /**
     * 选择堆中最大的值出队，数组中第一个为最大值
     *
     * @return
     */
    public int extractMax() {
        int max = data[1];

        //把最后一个值放在第一个位置上
        data[1] = data[size];
        size--;
        //对第一个元素进行shiftDown操作，在这个过程中重新排好这个二叉堆
        shiftDown(1);

        return max;
    }

    /**
     * 把二叉堆中的位置错误的某元素不断下移，把合适的元素放在原来的位置上，在这个过程中把二叉堆排列整齐
     *
     * @param k
     */
    private void shiftDown(int k) {
        //判断该结点是否有子节点，如果该节点有左结点那么肯定有子节点
        while (2 * k <= size) {

            int j = 2 * k;//在此轮循环中，data[k]和data[j]交换位置
            if (j + 1 <= size && data[j + 1] > data[j]) {
                j++;
            }
            if (data[k] >= data[j]) {
                break;
            }
            int swap = data[k];
            data[k] = data[j];
            data[j] = swap;

            //继续对下一个结点操作
            k = j;
        }
    }


    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(20);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            maxHeap.insert(r.nextInt(10));
        }
    }

}
