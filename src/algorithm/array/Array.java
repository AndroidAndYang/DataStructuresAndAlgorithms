package algorithm.array;

/**
 * author： YJZ
 * date:  2019/10/18
 * des: 普通的数组处理
 */
public class Array {

    private int size;
    private int[] data;
    private int count;

    public Array(int size) {
        data = new int[size];
        this.size = size;
        this.count = 0;
    }

    public boolean insert(int index, int value) {

        checkIndex(index);

        if (count == data.length) {
            return false;
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;

        ++count;

        return true;
    }

    public boolean contains(int value) {
        for (int values : data) {
            if (values == value) {
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * 获取全部数据
     */
    public void getAll() {
        if (data.length == 0) {
            System.out.println("data is empty!");
            return;
        }
        for (int i = 0; i < data.length - 1; i++) {
            System.out.println("arr index = " + i + " value = " + data[i]);
        }
    }

    /**
     * 检查索引
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index 超出范围");
        }
    }

    public static void main(String[] args) {
        // ---------------  Array 操作 ---------------
        Array array = new Array(5);
        array.insert(0, 3);
        array.insert(1, 4);
        array.insert(2, 5);
        array.insert(2, 9);
        array.getAll();
    }
}
