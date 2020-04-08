package algorithm.linkedlist;

/**
 * author： YJZ
 * date:  2019/11/8
 * des: 基于单链表的LRU(先进先出)
 */
public class LRUBaseLinkedList<T> {

    private static final Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    /**
     * 默认大小的初始化
     */
    public LRUBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseLinkedList(Integer capacity) {
        headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data){
        SNode<T> preNode = findPreNode(data);
        // 链表中存在，删除原数据，在插入到链表的头部
        if (preNode != null){
            deleteElemOpt(preNode);
            insertElemAtBegin(data);
        }else {
            if (length >= this.capacity){
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * 刪除尾部节点
     */
    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null){
            return;
        }

        // 倒数第二个节点
        while(ptr.getNext().getNext() != null){
            ptr = ptr.getNext();
        }

        SNode temp = ptr.getNext();
        ptr.setNext(null);
        temp = null;
        --length;
    }

    /**
     * 链表头部插入节点
     *
     * @param data value
     */
    private void insertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data,next));
        ++length;
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteElemOpt(SNode<T> preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        --length;
    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data value
     *
     * @return 上一个节点
     */
    private SNode<T> findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null){
            if (data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class SNode<T>{

        private T element;

        private SNode next;

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
}
