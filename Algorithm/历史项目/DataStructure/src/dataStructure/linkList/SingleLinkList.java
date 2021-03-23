package dataStructure.linkList;

import dataStructure.arrayList.List;

/**
 * 单链表
 */
public class SingleLinkList implements List {

    private Node head = new Node();//头结点，不存放数据，为了编程方便

    private int size;//结点的个数

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        Node p = head.getNext();
        for (int j = 0; j < i; j++) {
            p = p.getNext();
        }
        return p.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        Node p = head;
        for (int i = 0; i < size; i++) {
            p = p.getNext();
            if (p.getData() == e)
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        Node p = head;
        for (int i = 0; i < size; i++) {
            p = p.getNext();
            if (p.getData() == e)
                return i;
        }
        return -1;
    }

    @Override
    public void add(int i, Object e) {
        //找到前一个结点
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.getNext();
        }
        //新创建一个结点
        Node newNode = new Node(e);

        //指明新节点的直接后继
        newNode.setNext(p.getNext());
        //指明新节点的直接前驱
        p.setNext(newNode);

        size++;
    }

    @Override
    public void add(Object e) {
        this.add(size,e);
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        int index = this.indexOf(obj);
        if (index!=-1) {
            this.add(index, e);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        int index = indexOf(obj);
        if (index == size-1) {
            add(e);
            return true;
        } else if (index != -1) {
            this.add(index+1,e);
            return true;
        }
        return false;
    }

    @Override
    public Object remove(int i) {
        Node p = head.getNext();
        for (int j = 0; j < i-1; j++) {
            p = p.getNext();
        }
        Object o = p.getNext().getData();
        p.setNext(p.getNext().getNext());
        return o;
    }

    @Override
    public boolean remove(Object e) {
        int index = this.indexOf(e);
        if (index != -1) {
            this.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        Node p = head.getNext();
        for (int j = 0; j < i; j++) {
            p = p.getNext();
        }
        Object o = p.getData();
        p.setData(e);
        return o;
    }

    @Override
    public String toString() {
        Node p = head;
        String s = "[";
        for (int i = 0; i < size; i++) {
            p = p.getNext();
            if (i == size-1)
                s = s + p.getData();
            else s = s + p.getData()+",";
        }
        s = s + "]";
        return s;
    }
}
