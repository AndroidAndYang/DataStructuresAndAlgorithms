package algorithm.tree;

import algorithm.tree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

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

    /**
     * 添加一个值到二叉树中
     *
     * @param element element
     */
    public void add(E element) {
        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        // 添加的不是第一个节点
        // 找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int com = 0;
        while (node != null) {
            com = compare(element, node.element);
            parent = node;
            if (com > 0) {
                node = node.right;
            } else if (com < 0) {
                node = node.left;
            } else { // 相等
                node.element = element;
                return;
            }
        }
        // 看看插入到父节点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (com > 0) {
            parent.right = newNode;
        } else {
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
    public int compare(E e1, E e2) {
        if (customComparator != null) {
            return customComparator.compare(e1, e2);
        } else {
            return ((Comparable) e1).compareTo(e2);
        }
    }

    /**
     * 前序遍历,从根节点,然后前序遍历左子树,前序遍历右子树
     */
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /**
     * 中序遍历,中序遍历左子树,然后根节点,中序遍历右子树
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<E> node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.println(node.element);
        inOrderTraversal(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node<E> node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.element);
    }

    /**
     * 层序遍历
     */
    public void levelOrderTraversal() {

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            Node<E> left = poll.left;
            if (left != null) {
                queue.offer(left);
            }
            Node<E> right = poll.right;
            if (right != null) {
                queue.offer(right);
            }
            System.out.println(poll.element);
        }
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
