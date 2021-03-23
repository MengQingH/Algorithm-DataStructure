package dataStructure.linkList;


import dataStructure.arrayList.List;

public class TestLinkedList {
    public static void main(String[] args) {
        List list = new SingleLinkList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.size());
        System.out.println(list.get(3));
        System.out.println(list.isEmpty());
        System.out.println(list.toString());

    }
}
