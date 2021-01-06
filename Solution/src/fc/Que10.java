package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/6 下午11:06
 */
public class Que10 {
    /**
     * 这个题，要么以竖着一个的方块为基准，拼接剩下的方块，要么以横着的两个方块为基准，开始拼接。因为问的是能够拼接多少个2*n的矩形，所以矩形的宽为 2 。
     *
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        int m = 1, n = 2;
        for (int i = 3; i <= target; i++) {
            n = m + n;
            m = n - m;
        }
        return n;
    }
}
