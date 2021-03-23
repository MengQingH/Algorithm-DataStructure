package dataStructure.arrayList;

import java.util.Arrays;

/**
 * 顺序表，底层采用数组，长度可以动态变化
 * elementData.length表示的是数组开辟空间的长度
 * size表示数组中存放多少个元素
 */
public class ArrayList implements List {

    private Object[] elementData;//底层是一个数组，目前还没有确定长度

    private int size;//元素的个数

    /**
     * 构造方法
     *
     * @param initialCapacity 指定数组的长度
     */
    public ArrayList(int initialCapacity) {
        //给数组分配指定数量的空间
        elementData = new Object[initialCapacity];
        //指定初始化时元素的个数
        size = 0;
    }

    public ArrayList() {
        //给数组分配指定数量的空间
        this(4);
        //指定初始化时元素的个数
        //size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size)
            throw new MyArrayIndexOutOfBoundException("数组索引越界" + i);
//            throw new RuntimeException("数组索引错误"+i);
        else return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else return false;
    }

    @Override
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == e)
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == e)
                return i;
        }
        return -1;
    }

    @Override
    public void add(int i, Object e) {
        if (i < 0 || i >= size)
            throw new MyArrayIndexOutOfBoundException("数组索引越界" + i);
        //如果数组满了
        if (size == elementData.length) {
            grow();
        }
        //后移i及其后面的元素，从最后一个元素开始
        for (int j = size; j > i ; j--) {
            elementData[j] = elementData[j-1];
        }
        //给数组中i处赋值
        elementData[i] = e;
        size++;
    }

    @Override
    public void add(Object e) {
        //如果数组满了
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e;
        size++;
    }

    /**
     * 对数组进行扩容
     */
    private void grow(){
//            //新创建一个新的数组，长度是旧数组的两倍
//            Object[] newArray = new Object[elementData.length*2];
//            //把旧数组中的数据拷贝到新数组中
//            for (int i = 0; i < size; i++) {
//                newArray[i] = elementData[i];
//            }

//            //让elementData指向新数组
//            elementData = newArray;
        //
        elementData = Arrays.copyOf(elementData, elementData.length * 3/2);
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        int i = this.indexOf(obj);
        if (i != -1){
            this.add(i,e);
            return true;
        }else return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        int i = this.indexOf(obj);
        if (i != -1){
            this.add(i+1,e);
            return true;
        }
        return false;
    }

    @Override
    public Object remove(int i) {
        if (i < 0 || i >= size)
            throw new MyArrayIndexOutOfBoundException("数组索引越界" + i);
        Object e = elementData[0];
        for (int j = size-1; j > i; j--) {
            elementData[j-1] = elementData[j];
        }
        return e.toString();
    }

    @Override
    public boolean remove(Object e) {
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }

    @Override
    public String toString() {
        if (size==0){
            return "[]";
        }
        StringBuilder string = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i!=size-1)
                string.append(elementData[i]+",");
            else string.append(elementData[i]);

        }
        string.append("]");
        return string.toString();
    }
}
