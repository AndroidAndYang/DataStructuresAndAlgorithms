package algorithm.linkedlist.single;

import algorithm.base.AbstractList;
import algorithm.base.List;

/**
 * author： YJZ
 * date:  2020/3/24
 * des: 单链表
 */
public class SingleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            // next 为 first 是因为插入headNode不为空下一个next node 则为headNode
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.nextNode = new Node<>(element, prev.nextNode);
        }
        size++;
    }

    /**
     * 根据索引获取元素
     *
     * @param index 索引
     * @return Node
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }
        return node;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            first = node.nextNode;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.nextNode;
            prev.nextNode = node.nextNode;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = first.nextNode;
            }
        } else {
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) {
                    return i;
                }
                node = first.nextNode;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        Node node = first;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size = ").append(size);
        stringBuilder.append(", elements = [");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(node.element);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
            node = node.nextNode;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static class Node<E> {

        E element;
        Node<E> nextNode;

        Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }
    }

    public static void main(String[] args) {
        List<Integer> singleCircle = new SingleLinkedList<>();
        singleCircle.add(1);
        singleCircle.add(2);
        singleCircle.add(3);
        singleCircle.add(4);
        singleCircle.add(0, 0);
        singleCircle.add(singleCircle.size(), 5);

        singleCircle.remove(0);
        singleCircle.remove(singleCircle.size() - 1);

        System.out.println(singleCircle.set(1, 11));

        System.out.println(singleCircle.get(1));

        System.out.println(singleCircle.toString());
    }
}
