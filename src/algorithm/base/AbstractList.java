package algorithm.base;

/**
 * author： YJZ
 * date:  2020/3/24
 * des:
 */
public abstract class AbstractList<E> implements List<E> {

    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 元素的数量
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element 检验的值
     *
     * @return 是否包含
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     *
     * @param element 元素
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 检查索引是否数组越界
     *
     * @param index 索引
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }
}
