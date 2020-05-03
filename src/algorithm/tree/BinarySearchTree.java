package algorithm.tree;

import algorithm.tree.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @author: YJZ
 * data: 2020/5/3.
 * des: 二叉搜索树
 * require : 数据需要具有可比较性
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;
    private Node<E> root;

    private Comparator<E> customComparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> customComparator) {
        this.customComparator = customComparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void add(E e) {

        if (size == 0) {
            root = new Node<>(e, null);
            size++;
            return;
        }

        Node<E> node = root;
        Node<E> parent = null;
        int comparable = comparable(e, node.element);
        while (node != null) {
            parent = node;
            if (comparable > 0) {
                node = node.right;
            } else if (comparable < 0) {
                node = node.left;
            } else { // 相等
                return;
            }
        }

        Node<E> newNode = new Node<>(e, parent);
        if (comparable > 0) {
            parent.right = newNode;
        } else if (comparable < 0) {
            parent.left = newNode;
        }
        size++;
    }

    /**
     * 比较两个值的大小
     *
     * @param e1 比较的元素
     * @param e2 比较的元素
     * @return 1 表示e1 > e2 ,-1 表示e1 < e2, 0 表示相等
     */
    public int comparable(E e1, E e2) {

        if (customComparator != null) {
            return customComparator.compare(e1, e2);
        }

        return ((Comparable) e1).compareTo(e2);
    }

    public void remove() {

    }

    public boolean contains() {
        return false;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }
}
