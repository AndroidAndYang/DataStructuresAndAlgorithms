package algorithm.linkedlist;

import java.util.HashMap;

/**
 * author： YJZ
 * date:  2019/11/8
 * des: 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 */
public class LRUBaseArray<T> {

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 数量
     */
    private int count;
    /**
     * 存储的值
     */
    private int capacity;
    /**
     * 存儲的值
     */
    private T[] value;
    /**
     * 根据插入值的索引查找值是否存在
     */
    private HashMap<T, Integer> holder;

    public LRUBaseArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseArray(int capacity) {
        value = (T[]) new Object[capacity];
        holder = new HashMap<>(capacity);
        this.capacity = capacity;
        this.count = 0;
    }

    private void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }
        // 根据插入的值获取到索引
        Integer index = holder.get(object);
        // 如果数组中没有该值，该插入
        if (index == null) {
            // 数组空间已满
            if (isFull()) {
                // 移除最后一个value,并将信缓存的值插入到第一个位置
                removeAndCache(object);
            } else {
                // 空间够，直接缓存
                cache(object, count);
            }
        } else {
            // 数组中存在该插入的值，移除存在的值，并将新添加的值添加到第一个位置
            update(index);
        }
    }

    /**
     * 将现有的值移除，待添加的值插入到第一位
     *
     * @param index position
     */
    private void update(Integer index) {
        T target = value[index];
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存到第一位
     *
     * @param object value
     * @param end    position
     */
    private void cache(T object, int end) {
        // 数组右移
        rightShift(end);
        holder.put(object, 0);
        value[0] = object;
        ++count;
    }

    private void removeAndCache(T object) {
        Integer integer = holder.get(object);
        holder.remove(object);
        cache(object, count);
    }

    /**
     * 将数组右移
     *
     * @param end 位移结束的索引
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    private boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        LRUBaseArray<Integer> lru = new LRUBaseArray<>();
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        System.out.println(lru);
    }
}
