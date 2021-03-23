package dataStructure.arrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        java.util.ArrayList arrayList;
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        list.add(3,10);

        System.out.println(list.indexOf(10));
        System.out.println(list.contains(7));
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.get(3));
        System.out.println(list);
        System.out.println(list.contains(1));
        System.out.println(list.contains("aa"));
    }
}
