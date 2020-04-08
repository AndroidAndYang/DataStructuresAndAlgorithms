package algorithm.array;

import algorithm.base.AbstractList;

/**
 * author： YJZ
 * date:  2019/10/21
 * des: 通用性数组
 */
public class GenericArray<T> extends AbstractList<T> {

    private T[] arr;
    private int size;

    public GenericArray() {
        this.arr = (T[]) new Object[10];
    }

    public GenericArray(int capacity) {
        this.arr = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 获取数组容量
     */
    public int getCapacity() {
        return arr.length;
    }

    @Override
    public void clear() {
        size = 0;
    }

    /**
     * 修改指定位置元素
     *
     * @param index 索引
     * @param t     value
     */
    @Override
    public T set(int index, T t) {
        rangeCheck(index);
        T element = arr[index];
        arr[index] = t;
        return element;
    }

    /**
     * 获取某个索引的位置
     *
     * @param index 索引
     * @return t
     */
    @Override
    public T get(int index) {
        rangeCheck(index);
        return arr[index];
    }

    /**
     * 根据一个值查出它的索引
     *
     * @param value value
     * @return index
     */
    @Override
    public boolean contains(T value) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (value.equals(arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取对应元素的下标, 未找到，返回 -1
     *
     * @param e value
     * @return index
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 添加值到指定位置
     *
     * @param index 位置
     * @param value value
     * @return success or foil
     */
    @Override
    public void add(int index, T value) {
        rangeCheckForAdd(index);
        if (size == arr.length) {
            resize(size * 2);
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    /**
     * 添加到第一个
     *
     * @param value value
     */
    public void addFirst(T value) {
        add(0, value);
    }

    /**
     * 添加到最后一个
     *
     * @param value value
     */
    public void addLast(T value) {
        add(size, value);
    }

    /**
     * 移除指定元素
     *
     * @param index 索引
     */
    public T remove(int index) {
        rangeCheckForAdd(index);
        for (int i = size; i > index; i--) {
            arr[i - 1] = arr[i];
        }
        T element = arr[index];

        arr[index] = null;
        --size;
        // 缩容
        if (size == arr.length / 4 && arr.length / 2 != 0) {
            resize(arr.length / 2);
        }
        return element;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    /**
     * 删除第一个元素
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 删除末尾元素
     */
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * 扩容
     */
    private void resize(int capacity) {
        T[] newArr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    /**
     * 获取全部数据
     */
    public void getAll() {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("GenericArray index = " + i + " value = " + arr[i]);
        }
    }

    public static void main(String[] args) {
        GenericArray<Integer> genericArray = new GenericArray<>(5);
        genericArray.add(3);
        genericArray.add(4);
        genericArray.add(5);
        genericArray.add(9);
        genericArray.getAll();
    }

}
