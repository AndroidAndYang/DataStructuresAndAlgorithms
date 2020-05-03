package algorithm.tree;

import algorithm.tree.printer.BinaryTrees;

import java.util.Comparator;

/**
 * @author: YJZ
 * data: 2020/5/3.
 */
public class Main {

    public static void test1() {
        int[] arr = new int[]{7, 4, 9, 2, 5, 8, 13, 3};

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for (int value : arr) {
            binarySearchTree.add(value);
        }
        BinaryTrees.print(binarySearchTree);
    }

    public static void test2() {
        BinarySearchTree<Person> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(new Person(12));
        binarySearchTree.add(new Person(9));
        binarySearchTree.add(new Person(15));
        binarySearchTree.add(new Person(7));
        BinaryTrees.print(binarySearchTree);
    }

    public static void test3() {
        BinarySearchTree<Person> binarySearchTree = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        binarySearchTree.add(new Person(12));
        binarySearchTree.add(new Person(9));
        binarySearchTree.add(new Person(15));
        binarySearchTree.add(new Person(7));
        binarySearchTree.add(new Person(18));
        BinaryTrees.print(binarySearchTree);
    }

    public static void main(String[] args) {
        test1();
        System.out.println("\n");
        test2();
        System.out.println("\n");
        test3();
    }
}
