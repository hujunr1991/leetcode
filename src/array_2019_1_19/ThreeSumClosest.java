/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package array_2019_1_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * description
 *
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2019/01/19 16:07
 * @since 1.0
 */
public class ThreeSumClosest {
    public static void main(String[] args){
        int[] arr = {-1, 2, 1, -4};

        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int res = threeSumClosest(arr,target);
        System.out.println(res);

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - closest);
        for (int i=0; i<nums.length ; ++i) {
            int j = i+1;
            int k = nums.length-1;
//            closest = target- nums[i]-nums[j]-nums[k];
            while ( j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int newdiff = Math.abs(target -sum);
                if (diff > newdiff) {
                    diff = newdiff;
                    closest = sum;
                }
                if (target - sum >0 ) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return closest;
    }

}
