package algorithm.base;

/**
 * author： YJZ
 * date:  2020/3/24
 * des:
 */
public interface List<E> {

    public static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 元素的数量
     *
     * @return size
     */
    int size();

    /**
     * 是否为空
     *
     * @return isEmpty
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     *
     * @param element 元素
     * @return 是否存在
     */
    boolean contains(E element);

    /**
     * 添加元素到尾部
     *
     * @param element 元素
     */
    void add(E element);

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return element
     */
    E get(int index);

    /**
     * 设置index位置的元素
     *
     * @param index   位置
     * @param element 元素
     * @return 原来的元素ֵ
     */
    E set(int index, E element);

    /**
     * 在index位置插入一个元素
     *
     * @param index   位置
     * @param element 元素
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     *
     * @param index 位置
     * @return 移除元素的值
     */
    E remove(int index);

    /**
     * 查看元素的索引
     *
     * @param element 元素的值
     * @return 元素的索引
     */
    int indexOf(E element);
}
