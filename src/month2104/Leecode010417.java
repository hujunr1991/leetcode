package month2104;

import java.util.LinkedList;
import java.util.List;

/**
 * 斐波那契数列
 * 最常规的做法：递归求解---重叠⼦问题
 * 问题在于会多次计算重复的过程，因此需要中间存储
 */
public class Leecode010417 {

    public static void main(String[] args) {

    }

    public int fib(int n) {

        if (n < 2) {
            return n;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
               int sum = pre + cur;
               pre = cur;
               cur = sum;
        }
        return cur;


    }



}
