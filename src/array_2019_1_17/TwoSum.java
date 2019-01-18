/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package array_2019_1_17;

import java.util.HashMap;
import java.util.Scanner;

/**
 * description
 *
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2019/01/18 09:03
 * @since 1.0
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,6,7,5,9,14};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[] indexs = twoSum(arr,target);
        for(int i:indexs){
            System.out.println(i);
        }

    }

    public static int[] twoSum(int[] nums,int target) {
        int[] res = new int[2];

        HashMap<Integer,Integer> m = new HashMap<>();

        for (int i = 0;i<nums.length;i++) {
            m.put(nums[i],i);
        }
        for (int i =0;i<nums.length;i++) {
            int result = target-nums[i];
            if (m.containsKey(result) && m.get(result) !=i ) {
                res[0] = i;
                res[1] = m.get(result);
                break;
            }
        }
            return res;
    }

}
