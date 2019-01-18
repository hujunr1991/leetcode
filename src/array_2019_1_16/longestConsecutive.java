/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package array_2019_1_16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * description
 *
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2019/01/16 17:17
 * @since 1.0
 */
public class longestConsecutive {

    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入需要查找的值：");
//        int target = scanner.nextInt();
        int arr[] = {100, 4, 200, 1, 3, 2,5};
        int longest= longestConsecutivenum(arr);
        int longest02= longestConsecutive02(arr);
        System.out.println(longest02);
    }

    public static int longestConsecutivenum(int[] arr){
        int res = 0;
        Set<Integer> s = new HashSet<>();
        for (int i:arr) {
            s.add(i);
        }
        for (int num:arr) {
            if (s.remove(num)) {
                int pre = num-1;
                int next = num+1;
                while (s.remove(pre)) --pre;
                while (s.remove(next)) ++next;
                res = Math.max(res,next-pre-1);
            }
        }
        return res;
    }


    public static int longestConsecutive02(int[] nums) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (m.containsKey(num)) continue;
            int left = m.containsKey(num - 1) ? m.get(num - 1) : 0;
            int right = m.containsKey(num + 1) ? m.get(num + 1) : 0;
            int sum = left + right + 1;
            m.put(num, sum);
            res = Math.max(res, sum);
            m.put(num - left, sum);
            m.put(num + right, sum);
        }
        return res;
    }
}
