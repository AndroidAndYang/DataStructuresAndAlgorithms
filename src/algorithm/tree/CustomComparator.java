package algorithm.tree;

/**
 * @author: YJZ
 * data: 2020/5/3.
 * des: 自己实现的比较器,java官方实现{@link java.util.Comparator}，自己实现只能比较自定义的数据类型，不能比较基本类型
 */
public interface CustomComparator<E> {
    int compare(E e1, E e2);
}
