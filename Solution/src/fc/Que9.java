package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/6 下午8:17
 */
public class Que9 {

    /**
     * 说明：
     *
     * 1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。
     *
     * 2）n = 1时，只有1种跳法，f(1) = 1
     *
     * 3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)
     *
     * 4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
     *
     *     那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
     *
     *     因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
     *
     * 5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
     *
     *     f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
     *
     * 6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：
     *
     *     f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     *
     *     f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     *
     *     可以得出：
     *
     *     f(n) = 2*f(n-1)
     *
     * 7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
     *
     *               | 1       ,(n=0 )
     *
     * f(n) =        | 1       ,(n=1 )
     *
     *               | 2*f(n-1),(n>=2)
     * @param target
     * @return
     */

    /**
     * 第一种解法，暴力解法，截止到上述步骤 5
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1 || target == 2) {
            return target;
        }

        int res = 0;
        for (int i = target; i > 0; i--) {
            res += JumpFloorII(target - i);
        }
        return res;
    }

    /**
     * 总结下来其是简化解法 步骤7）  f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     *
     * @param target
     * @return
     */
    public int JumpFloorII2(int target) {
        int res = 0;
        if (target == 0) {
            return 1;
        } else if (target == 1) {
            return target;
        } else {
            res += 2 * JumpFloorII(target - 1);
        }
        return res;
    }

    /**
     * 其实如果不限制上楼梯层数的话，每个楼梯的层数都是可以选择踩或者不踩，最后一个楼梯一定是要踩的，所以只需要判定n-1个楼梯每个楼梯是否踩或者不踩
     * 解题思路千千万呀，不要为了刷题而刷题，要拓展思路，不要停止学习的脚步。
     * @param target
     * @return
     */
    public int JumpFloorII3(int target) {
        return target <= 0 ? 0 : 1 << (target - 1);
    }


}
