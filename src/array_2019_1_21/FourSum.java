/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package array_2019_1_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


/**
 * description
 *
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2019/01/21 11:45
 * @since 1.0
 */
public class FourSum {

    public static void main(String[] args){
        int[] arr = {1, 0, -1, 0, -2, 2};

        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
       // List<List<Integer>> res = fourSum(arr,target);
        List<List<Integer>> res = fourSum02(arr,target);

        for (List<Integer> list:res) {
            System.out.println(list);
        }

    }

    /**
     * 解法一：在sum上加一层循环,在 3Sum 的基础上再加一层循环即可，3Sum 时间复杂度为 O(n2)，所以这个方法时间复杂度为 O(n3)。
     * @param nums 数组
     * @param target 目标数
     * @return 组合
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        for (int i = 0;i<nums.length-3; ++i) {
            if (i>0 && nums[i] == nums[i-1])  continue;
            for (int j =i+1; j<nums.length-2;++j) {
                if (j>i+1 && nums[j-1] == nums[j]) continue;
                int left = j+1;
                int right = nums.length-1;
                while (left <right) {
                    int sum = nums[i]+nums[j] + nums[left]+nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right && nums[left] == nums[left+1]) ++left;
                        while (left<right && nums[right] == nums[right-1])  --right;
                        left++;
                        --right;
                    }else if (sum<target)  ++left;
                    else --right;
                }

            }
        }
        return result;
    }


    /**
     *　先排序 (O(nlogn))，然后遍历整个数组，以每两个数的和作为key将两个数的index存于HashMap中，
     * 由于存在和相同的情况，因此HashMap中的每个键对应的是一个List，每个List中保存着多组index对，
     * 这一操作时间复杂度为 (O(n2))。
     */
    private static List<List<Integer>> fourSum02(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        HashMap<Integer,List<Integer[]>> map = new HashMap<>();
        //把两两之和统计出来，并存在map中
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j =i+1; j<nums.length;j++) {

                int sum = nums[i]+nums[j];
                Integer[] pair = {i,j};

                if (!map.containsKey(sum)) {
                    map.put(sum,new ArrayList<Integer[]>());
                }
                map.get(sum).add(pair);
            }
        }


        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            List<Integer[]> listA = map.get(key);
            List<Integer[]> listB = map.get(target - key);
            if (listA != null && listB != null) {
                for (Integer[] pairA : listA) {
                    int a0 = pairA[0];
                    int a1 = pairA[1];
                    for (Integer[] pairB : listB) {
                        int b0 = pairB[0], b1 = pairB[1];
                        // 因为肯定存在： a0 < a1, b0 < b1
                        if (a1 < b0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[a0]);
                            list.add(nums[a1]);
                            list.add(nums[b0]);
                            list.add(nums[b1]);
                            if (!res.contains(list)) res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }


}
