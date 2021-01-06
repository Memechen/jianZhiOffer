package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/6 下午7:42
 */
public class Que8 {
    public int JumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
