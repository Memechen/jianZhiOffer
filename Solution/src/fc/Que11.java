package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/7 下午2:52
 */
public class Que11 {
    /**
     * 3的二进制位是0000 0011 ， 5的二进制位是0000 0101 ， 那么就是011 & 101，由按位与运算规则得知，001 & 101等于0000 0001，最终值为1
     * >>> "无符号右移运算符"和"右移运算符"的主要区别在于负数的计算，因为无符号右移是高位补0，移多少位补多少个0。
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

}
