package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/7 下午5:05
 */
public class Que12 {
    /**
     * 暴力解法，直接算出解法步骤
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean falg = true;
        if (exponent < 0) {
            falg = false;
            exponent = -1 * exponent;
        }

        double res = 1;
        while (exponent > 0) {
            res *= base;
            exponent--;
        }

        return falg ? res : 1 / res;
    }

    /**
     * 3^7  ==  3^6 * 3
     *      ==  (3 * 3) ^ 3 * 3
     *      ==
     * @param base
     * @param exponent
     * @return
     */
    public double Power2(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean falg = true;
        if (exponent < 0) {
            falg = false;
            exponent = -1 * exponent;
        }

        double res = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                res *= base;
            }
            base *= base;
            exponent >>= 1;
        }

        return falg ? res : 1 / res;
    }

}
