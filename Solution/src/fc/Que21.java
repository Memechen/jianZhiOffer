package fc;

import java.util.Stack;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/18 下午8:16
 */
public class Que21 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {

        if(pushA.length != popA.length){
            return false;
        }

        Stack<Integer> stack = new Stack();

        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (stack.isEmpty()){
                stack.push(pushA[i]);
            }else {
                if (popA[index] != stack.peek()) {
                    stack.push(pushA[i]);
                } else {
                    index ++;
                }
            }
        }

        while (!stack.isEmpty()) {
            Integer pop = (Integer) stack.pop();
            if (pop != popA[index]) {
                return false;
            }
            index++;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
    }
}
