package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/2/22 下午5:06
 */
public class Que31 {

    /**
     * 思路1：暴力解法，复杂度O(n)
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;

        for (int i = 1; i <= n; i++) {
            res += getCount(i);
        }

        return res;
    }

    private int getCount(int i) {
        int res = 0;
        while (i > 0){
            if (i % 10 == 1){
                res += 1;
            }
            i = i/10;
        }
        System.out.println(res);
        return res;
    }


    //https://blog.csdn.net/huzhigenlaohu/article/details/51779365

    /**
     * 思路2：避免不必要的判断，归纳数字1在各个位时，能够产生的数字，即为出现个数，将所有个数相加，详情见：https://blog.csdn.net/huzhigenlaohu/article/details/51779365
     *
     * 概括分析可得：用2593举例
     * 当 x < 要判定的位数上的数字时，如2593的十位为9，x为本题中要求的1的个数，即为1，公式为：[（更高位数字+1）* 当前位数的权重10^(i-1)] 即 （25+1）* 1 * 10^(2-1) = 260 次
     *
     * 通用公式如下：此题中x=1
     * x > 要判定的位数上的数字时 公式为： [（更高位数字）* 当前位数的权重10^(i-1)]
     * x < 要判定的位数上的数字时 公式为： [（更高位数字+1）* 当前位数的权重10^(i-1)]
     * x = 要判定的位数上的数字时 公式为： [（更高位数字+1）* 当前位数的权重10^(i-1) + （地位数字 + 1）]
     *
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution2(int n) {
        int res = 0;

        for (int i = 1; i <= n; i++) {
            res += getCount(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Que31().NumberOf1Between1AndN_Solution(99);
        System.out.println(res);
    }
}
