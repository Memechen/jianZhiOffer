package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/19 下午2:51
 */
public class Que23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }

        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int[] a, int start, int end) {
        // 结束条件
        if (start >= end) {
            return true;
        }
        // 找到比root节点小的左子树在数组中的坐标
        int i = start;
        while (a[i] < a[end]) {
            ++i;
        }
        // 此时数组中坐标右边的数应该都大于右子树。
        for (int j = i; j < end; j++) {
            if (a[j] < a[end]) {
                return false;
            }
        }

        return VerifySquenceOfBST(a, start, i - 1) && VerifySquenceOfBST(a, i, end - 1);
    }
}
