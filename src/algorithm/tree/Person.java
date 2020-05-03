package algorithm.tree;

/**
 * @author: YJZ
 * data: 2020/5/3.
 * des: 自定义的类需要在二叉树搜索树中使用必须得要实现Comparable接口,或者自己实现Comparator比较器
 */
public class Person implements Comparable<Person> {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.getAge();
    }
}
