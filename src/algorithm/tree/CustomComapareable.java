package algorithm.tree;

/**
 * @author: YJZ
 * data: 2020/5/3.
 * 比较方法,官方实现{@link java.lang.Comparable}，自己实现只能比较自定义的数据类型，不能比较基本类型
 */
public interface CustomComapareable<E> {

    int compareTo(E e);
}
