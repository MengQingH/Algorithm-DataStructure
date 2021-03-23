package dataStructure.binarySearchTree;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(new Node(10, "10"));
        bst.add(new Node(15, "15"));
        bst.add(new Node(12, "12"));
        bst.add(new Node(13, "13"));
        bst.add(new Node(9, "9"));
        bst.add(new Node(5, "5"));
        bst.add(new Node(7, "7"));
        bst.add(new Node(8, "8"));

        System.out.println(bst.size());

        System.out.println(bst.contain(10));
        System.out.println(bst.contain(12));
        System.out.println(bst.contain(7));

        System.out.println(bst.search(10));
        System.out.println(bst.search(8));
    }
}
