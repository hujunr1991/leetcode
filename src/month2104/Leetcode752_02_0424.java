package month2104;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class Leetcode752_02_0424 {

    public int openLock(String[] deadends, String target) {
        //将数字放在集合中
        Set<String> deads = new HashSet<>();
        for (String s:deadends) {
            deads.add(s);
        }
        // 记录已经穷举过的密码， 防⽌⾛回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动⼴度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i =0 ;i < size; i++) {
                String poll = q.poll();
                //判断是否到达中终点
                if (deads.contains(poll)) {
                    continue;
                }
                if (poll.equals(target)) {
                    return step;
                }

                //将⼀个节点的未遍历相邻节点加⼊队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(poll, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }

                    String down = minusOne(poll, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        // 如果穷举完都没找到⽬标密码， 那就是找不到了
        return -1;
    }

    private String plusOne(String s , int j) {
        char[] chars = s.toCharArray();

        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            int i = chars[j] + 1;
            chars[j] = (char) i;
        }
        return String.valueOf(chars);

    }

    private String minusOne(String s , int j) {
        char[] chars = s.toCharArray();

        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            int i = chars[j] - 1;
            chars[j] = (char) i;
        }
        return String.valueOf(chars);

    }

    private void BSF(String target) {

        Queue<String> queue = new LinkedList<>();

        queue.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i< size; i++) {
                String remove = queue.remove();
                System.out.println(remove);

                for (int j=0; j <4; j++) {
                    String plus = plusOne(remove, j);
                    String min = minusOne(remove, j);
                    queue.add(plus);
                    queue.add(min);
                }
            }
        }
        return;
    }


    public static void main(String[] args) {
        Leetcode752_02_0424 leetcode752020424 = new Leetcode752_02_0424();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        int i = leetcode752020424.openLock(deadends, "0202");
        System.out.println(i);
    }
}


