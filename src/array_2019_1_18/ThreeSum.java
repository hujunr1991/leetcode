/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package array_2019_1_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description
 *
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2019/01/18 17:28
 * @since 1.0
 */
public class ThreeSum {
    public static void main(String[] args){
        int[] arr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> res = new ArrayList<>();
        res = threeSum(arr);

        for (List<Integer> list:res) {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //先排序
         Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
         //判断排序后长度、是否全是负数、正数
         if (nums.length < 2 || nums[0] >0 || nums[nums.length-1] <0 ) {
             return result;
         }

         for (int i=0; i<nums.length;i++) {

             //第一个剔除的数在有序数中只能是负数
             if (nums[i] > 0 ) break;

             //处理重复的数据
             if (i>0 && nums[i] == nums[i-1]) continue;

             int target = 0 - nums[i];
             //双指针法
             int j = i+1;
             int k = nums.length-1;
             /**
              * 总体的思想是两端逼近，小于target就左边+1，大于则右边-1，如何数相同则跳过
              */
             while(j < k ) {
                if (nums[j] + nums[k] == target) {
                    result.add(Arrays.asList(nums[i],nums[j], nums[k]));
                    while(j<k && nums[j] == nums[j+1]) j++;
                    while(j<k && nums[k] == nums[k-1]) k--;
                    ++j;
                    --k;
                } else if (nums[j] + nums[k] < target) {
                    ++j;
                }else {
                    --k;
                }
             }
         }
         return result;

    }
}
