package month2101;

import java.util.Stack;

public class Problem210108 {
    /**
     * 思路是利用一个辅助栈，辅助栈每次压入的是当前的最小值
     */

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> helper = new Stack<Integer>();


    /**
     * 利用辅助栈存储栈中对应元素的最小值，使得辅助栈的栈顶永远是最小值，从而可以以o(1)的时间复杂度获取到最小值
     * @param node
     */
    public void push(int node) {
        stack.push(node);
        if(helper.empty() || node <= helper.peek()) {
            helper.push(node);
        }
    }

    public  void pop() {
        if(!stack.empty()) {
            if(stack.peek() == helper.peek()) {
                helper.pop();
            }
            stack.pop();
        }
    }

    public int top() {
        if(!stack.empty()) {
            return stack.peek();
        }
        throw new RuntimeException("栈空");
    }

    public int min() {
        if(!stack.empty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈空");
    }


}
