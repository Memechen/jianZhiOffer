package fc;

import java.util.Stack;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/18 下午8:16
 */
public class Que21 {
    /**
     * 模拟整个入栈过程
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {

        if(pushA.length != popA.length){
            return false;
        }
        //增加一个辅助栈
        Stack<Integer> stack = new Stack();
        int popindex = 0;

        for (int i = 0; i < pushA.length; i++) {
            //入栈
            stack.push(pushA[i]);
            //判断栈顶元素是否等价于出栈的元素，如果相等，则弹出，出栈元素列表下标后移一位
            while (!stack.isEmpty() && stack.peek() == popA[popindex]){
                stack.pop();
                popindex++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
    }
}
