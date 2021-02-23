package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/2/22 下午4:44
 */
public class Que30 {
    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null) {
            return 0;
        }
        int sum = array[0];
        int maxsum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = sum < 0 ? array[i] : array[i] + sum;
            maxsum = sum > maxsum ? sum : maxsum;
        }

        return maxsum;
    }

    public static void main(String[] args) {
        new Que30().FindGreatestSumOfSubArray(new int[]{1,2,3,-3,6});
    }
}
