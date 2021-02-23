package fc;

import java.util.Arrays;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/2/19 下午3:32
 */
public class Que28 {
    /**
     * 在遍历数组时保存两个值：一是数组中一个数字，一是次数。
     * 遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int pre = 0;
        int count = 1;

        for (int i = 0; i < array.length; i++) {
            if (i==0){
                pre = array[0];
            }else {
                if (count == 0) {
                    pre = array[i];
                    count = 1;
                } else if (array[i] == pre) {
                    count++;
                } else {
                    count--;
                }

            }
        }
        // 防止数组内出现次数最多的那个数，出现的次数不够数组长度的一半。例如：[1,2,3,2,3,2,5,4,2]，2出现了4次最多，但是不够数组长度的一半。
        count = 0;
        for (int i=0; i<array.length; i++){
            if(array[i] == pre){
                count ++;
            }
        }

        return (count > array.length/2)? pre : 0;
    }

    /**
     * 方法2、排序数组，出现最多的应该是在数组的最中心，既然超过数组长度的一半的话。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int [] array) {
        int res = 0;
        Arrays.sort(array);
        res = array[array.length/2];

        // 防止数组内出现次数最多的那个数，出现的次数不够数组长度的一半。例如：[1,2,3,2,3,2,5,4,2]，2出现了4次最多，但是不够数组长度的一半。
        int count = 0;
        for (int i=0; i<array.length; i++){
            if(array[i] == res){
                count ++;
            }
        }

        return (count > array.length/2)? res : 0;
    }


    public static void main(String[] args) {
        new Que28().MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2});
    }
}
