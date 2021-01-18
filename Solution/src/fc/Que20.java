package fc;

import java.util.Stack;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/18 下午7:56
 */
public class Que20 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.isEmpty()){
            min.push(node);
        }else if (node < min.peek()){
            min.push(node);
        }
    }

    public void pop() {
        if (min.peek().equals(stack.peek())){
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if (!min.isEmpty()){
            return min.peek();
        }else {
            return 0;
        }
    }
}
