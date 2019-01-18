/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package array_2018_12_4;

import java.util.Scanner;

/**
 * description
 *
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2018/12/05 11:25
 * @since 1.0
 */
public class RemoveDuplicatesTwo {
    public static void main(String[] args) {
        System.out.println("请输入测试数据：");
        Scanner scanner = new Scanner(System.in);
        int arr[] = {1,1,1,1,2,2,3};

//        removeDuplicates(arr,arr.length);

        int index = removeDuplicates1(arr);

        for(int i=0;i<index;i++) {
            System.out.println(arr[i]);
        }
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int pre = 0, cur = 1, count = 1;
        while (cur < nums.length) {
            if (nums[pre] == nums[cur] && count == 0) ++cur;
            else {
                if (nums[pre] == nums[cur]) --count;
                else count = 1;
                nums[++pre] = nums[cur++];
            }
        }
        return pre + 1;
    }

    //这种太难了，我想不到
    private static int removeDuplicates1(int[] nums) {
     //dup为允许重复的次数
        int dup = 3;
        if(nums.length <= dup) return nums.length;
        int index = dup;
        for (int i=dup; i<nums.length;i++){
            //比较第0个和第2个下标的值，如果不相等则
            if(nums[index-dup] != nums[i]){
                nums[index++] =nums[i];
            }
        }

        return index;
    }

    //这个扩展太差，不好
    private static int removeDuplicates02(int[] nums) {
        //至多2个从长度2开始
        if (nums.length <= 2) return nums.length;
        int index = 0;
        for (int i=1; i<nums.length;i++){
            if(i>0 && i<nums.length-1 && nums[i] == nums[i-1] && nums[i]==nums[i+1]){
                continue;
            }
            index++;
            nums[index] = nums[i];
        }
        return index+1;
    }
}
