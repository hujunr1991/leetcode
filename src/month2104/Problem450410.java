package month2104;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 45：圆圈中最后剩下的数字
 * 思路：第一种方法是模拟出这个环
 * 第二种方法是数学问题
 */
public class Problem450410 {

    public static void main(String[] args) {

        Problem450410 p=new Problem450410();
        System.out.println(p.lastRemaining(6, 3));
    }

    //第一种方法：环操作
    private int lastRemaining(int n, int m) {
        if (n < 1 || m <1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 要删除元素的位置
        int idx = 0;
        // 开始计数的位置
        int start = 0;
        while (list.size() >1) {
            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i=0; i < m; i++) {
                idx = (m+1) % list.size();
            }
            list.remove(idx);
        }
        return list.get(0);
    }

    //公式法
    public static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <=n ; i++) {
            last = (last + m)%i;
        }
        return last;
    }


}
