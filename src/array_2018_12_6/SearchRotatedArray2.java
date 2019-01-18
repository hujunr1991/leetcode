/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package array_2018_12_6;

import java.util.Scanner;

/**
 * description
 *在旋转的有序数组中存在重复元素
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2018/12/07 14:43
 * @since 1.0
 */
public class SearchRotatedArray2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查找的值：");
        int target = scanner.nextInt();
        int arr[] = {4,5,5,6,7,0,0,1,2};
        boolean flag= search(arr,target);
        System.out.println(flag);
    }

    /**
     *   这道题与之前Search in Rotated Sorted Array类似，问题只在于存在dupilcate。那么和之前那道题的解法区别就是，
     *   不能通过比较A[mid]和边缘值来确定哪边是有序的，会出现A[mid]与边缘值相等的状态。所以，
     *   解决方法就是对于A[mid]==A[low]和A[mid]==A[high]单独处理。
     *   当中间值与边缘值相等时，让指向边缘值的指针分别往前移动，忽略掉这个相同点，再用之前的方法判断即可。
     */
    private static boolean search(int nums[],int target){
        if (nums ==null && nums.length==0) {
            return false;
        }
        int l =0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;

            if (nums[mid]==target){
                return true;
            }
            if (nums[mid]>nums[l]){
                if (nums[mid]>target && nums[l]<=target){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }
            else if (nums[mid]<nums[l]) {
                if (nums[mid]<target && nums[r]>=target) {
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
            else {
                l++;
            }
        }
        return false;

    }
}
