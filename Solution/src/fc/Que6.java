package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/6 下午4:13
 */
public class Que6 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }

        return 0;
    }

    /**
     * 二分法判定
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        int left = 0;
        int right = array.length - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (array[mid] > array[left]) {
                left = mid;
            } else if (array[mid] == array[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return array[left];
    }

    public static void main(String[] args) {
        minNumberInRotateArray2(new int[]{1, 2, 3, 4, 5, 6});
    }
}
