package fc;

import java.util.ArrayList;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/6 下午7:01
 */
public class Que7 {
    public static int Fibonacci(int n) {

        ArrayList<Integer> res = new ArrayList<>();

        res.add(0, 0);
        res.add(1, 1);

        for (int i = 2; i <= n; i++) {
            res.add(i, res.get(i - 2) + res.get(i - 1));
        }

        return res.get(n);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(0));
    }
}
