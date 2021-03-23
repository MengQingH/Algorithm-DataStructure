package dataStructure.maxHeap;

import java.util.Arrays;

/**
 * 最大索引堆
 * 索引堆中的索引数组就相当于原来的二叉堆，原来对二叉堆进行的操作现在对索引堆进行，只不过比较的时候比较的是data数组中的内容
 * reverse数组是为了优化替换元素效率低的问题，也可以不使用，删除前面方法中的reverse数组的语句
 */
public class IndexMaxHeap {
    //存放堆中的数据
    private int[] data;
    //堆中数据的个数
    private int size;
    //堆中可以存放的数据个数。capacity相当于一般数组中的arr.length，不过arr.length是[0,arr.length-1]，capacity是[1,capacity]
    private int capacity;
    //添加一个索引数组
    private int[] indexes;
    //添加一个某个data的索引在indexes数组中的索引的数组
    private int[] reverse;

    /**
     * 构造函数，根据指定的长度创建二叉堆，由于存放二叉堆是从1开始的，所以初始化时长度要+1
     * 使用这种方式创建一个二叉堆并把n个元素插入到空堆中，算法复杂度为O(nlogn)
     *
     * @param capacity 指定数组的长度
     */
    public IndexMaxHeap(int capacity) {
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        this.capacity = capacity;
        size = 0;
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
     * 传入一个元素和该元素的索引，向二叉堆中插入一个元素，并放到合适的位置
     * 在堆中由于索引是从1开始的，但是在外部用户插入时看到的索引是从0开始的。
     *
     * @param i 传入的是从0开始的索引，所以插入时需要处理索引的差异
     * @param e
     * @return
     */
    public boolean insert(int i, int e) {
        //空间不足的时候进行扩容
        if (size + 1 > capacity) {
            capacity = capacity * 2;
            data = Arrays.copyOf(data, capacity + 1);
        }
        //当插入的索引条件正确的时候进行插入
        if (i + 1 >= 1 && i + 1 <= capacity) {
            //把传入从0开始的索引变为从1开始的索引
            i++;
            //在data数组中把该元素赋给相应的索引
            data[i] = e;
            //把索引添加到索引数组最后的位置上，准备shiftUp操作
            indexes[size + 1] = i;

            //把该元素的索引在indexes数组中的索引信息添加到reverse中
            reverse[i] = size + 1;

            size++;
            shiftUp(size);
            return true;
        } else return false;
    }

    /**
     * 把添加的元素放到合适的位置：不断和该节点的父节点比较，如果大于父节点，就交换两个结点
     * 在索引树中，需要比较的是data中的值，而进行交换的是索引数组中的值
     *
     * @param k 在索引堆中存放二叉堆元素序列的是索引数组，所以k是索引数组中的位置
     */
    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {
            int swap = indexes[k / 2];
            indexes[k / 2] = indexes[k];
            indexes[k] = swap;

            //交换两个元素的同时，更新reverse中的索引信息
            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;

            k = k / 2;
        }
    }


    /**
     * 选择堆中最大的值出队，数组中第一个为最大值
     *
     * @return
     */
    public int extractMax() {
        int max = data[indexes[1]];

        //把索引数组中最后一个值放在第一个位置上
        indexes[1] = indexes[size];

        reverse[indexes[1]] = 1;

        size--;
        //对索引数组中第一个元素进行shiftDown操作，在这个过程中排好这个二叉堆
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
            if (j + 1 <= size && data[indexes[j + 1]] > data[indexes[j]]) {
                j++;
            }
            if (data[indexes[k]] >= data[indexes[j]]) {
                break;
            }
            int swap = indexes[k];
            indexes[k] = indexes[j];
            indexes[j] = swap;

            //更新reverse数组信息
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;

            //继续对下一个结点操作
            k = j;
        }
    }

    /**
     * 下面的函数是索引堆中独有的函数
     */


    /**
     * 返回索引堆中最大元素的索引
     *
     * @return
     */
    public int extractMaxIndex() {
        //由于索引堆中索引是从1开始的，所以返回索引到外部从0开始时，要-1
        int maxIndex = indexes[1] - 1;

        //把索引数组中最后一个值放在第一个位置上
        indexes[1] = indexes[size];
        reverse[indexes[1]] = 1;
        size--;
        //对索引数组中第一个元素进行shiftDown操作，在这个过程中排好这个二叉堆
        shiftDown(1);

        return maxIndex;
    }

    /**
     * 封装一个判断索引堆中某个索引位置上是否有值的函数
     *
     * @param i
     * @return
     */
    public boolean contain(int i) {
        return reverse[i + 1] != 0;
    }

    /**
     * 通过索引取出x'x元素
     *
     * @param index
     * @return
     */
    public int getElement(int index) {
        return data[index + 1];
    }

    /**
     * 把堆中某位置上的元素替换为另一个元素（不使用reverse数组）
     * 时间复杂度分析：寻找该元素在indexes中的位置的时间复杂度为O(n)，而shiftUp和shiftDown都是O(logn)级别的，
     * 所以最差情况下时间复杂度为O(n+logn)即O(n)级别的算法，如果进行n个该操作，最坏情况下总的情况就有可能达到O(n^2)，效率低下
     *
     * @param i
     * @param newElement
     */
    public void replace(int i, int newElement) {
        //把该索引位置上的元素变为新元素
        i++;
        data[i] = newElement;

        //对堆中新插入的元素进行排序，使二叉堆中的元素位置正确
        //1.找到indexes[j] = i，j表示data[i]在堆中的位置
        //2.先对该元素进行shiftUp操作，再进行shiftDown操作
        for (int j = 1; j < size; j++) {
            if (indexes[j] == i) {
                shiftDown(j);
                shiftUp(j);
            }
        }
    }

    /**
     * 把堆中某个位置的元素替换为另一个元素（使用reverse数组）
     * 时间复杂度分析：由于查找元素在indexes数组中的位置直接完成，所以这一步时间复杂度变为了O(1)
     * shiftDown,shiftUp时间复杂度为O(logn)，所以总的时间复杂度变为了O(logn)
     *
     * @param i
     * @param newElement
     */
    public void replace_im(int i, int newElement) {
        //把该索引位置上的元素变为新元素
        i++;
        data[i] = newElement;

        //直接通过reverse数组找到该位置上的元素在indexes数组中的位置
        int j = reverse[i];
        //进行shiftDown、shiftUp操作
        shiftDown(j);
        shiftUp(j);

    }
}
