package month2101;

import java.util.Stack;

public class Problem220108 {


    /**
     * 栈的压入、弹出序列--剑指offer22
     * 在这个问题上，借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，
     * 然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，
     * 出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，
     * 说明弹出序列不是该栈的弹出顺序
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0||popA.length!=pushA.length)
            return false;
        Stack<Integer> stack=new Stack<Integer>();
        int j=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty()&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int [] pushA = {1,2,3,4,5};
        int [] popA = {4,5,3,2,1};
        boolean b = IsPopOrder(pushA, popA);
    }
}
