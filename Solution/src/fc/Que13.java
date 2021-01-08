package fc;

import java.util.ArrayList;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/8 上午10:15
 */
public class Que13 {

    /**
     * 空间换时间，通过额外申请的空间去减少循环的次数。
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        // 准备一个额外的空间存储偶数集合
        ArrayList<Integer> other = new ArrayList<>();
        // 准备一个游标记录奇数覆盖的位置，每次递增一个，相当于将数组中的奇数一个一个往前提。
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                other.add(array[i]);
            } else {
                array[index++] = array[i];
            }
        }
        // 定位到奇数的个数，也是偶数在原数组中下标开始的位置。将偶数集合中的数据添加到原数组的后面。
        index = array.length-other.size();
        for (int i = 0; i < other.size(); i++) {
            array[index++] = other.get(i);
        }
    }

    /**
     * 时间复杂度高，类似于插入排序，遇到奇数就向前看，是否有偶数，如果有偶数，则更换双方的位置。每次都和最后一个元素更换。
     * <p>
     * 1，2，4，6，8，5  遍历到5之后开始换位，5与2换位
     * 1，5，4，6，8，2  此时每次都和最后一个元素更换，最后一个元素由于更换会一直变，2与4换位
     * 1，5，2，6，8，4  4与6换位
     * 1，5，2，4，8，6  ......
     * 1，5，2，4，6，8  完成所有换位
     *
     * @param array
     */
    public static void reOrderArray1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 如果该数为奇数，则运行换位逻辑
            if (array[i] % 2 == 1) {
                for (int index = 0; index < i; index++) {
                    if (array[index] % 2 == 0) {
                        int t = array[index];
                        array[index] = array[i];
                        array[i] = t;
                    }
                }
            }
        }
    }

}
