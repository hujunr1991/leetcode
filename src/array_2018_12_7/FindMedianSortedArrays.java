/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package array_2018_12_7;

import java.util.Scanner;

/**
 * description
 *
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2018/12/12 17:56
 * @since 1.0
 */
public class FindMedianSortedArrays {
    //这道题让我们求两个有序数组的中位数，而且限制了时间复杂度为O(log (m+n)
    /**
     * 思路：（1）需要奇、偶条件判断：
     * 这道题让我们求两个有序数组的中位数，而且限制了时间复杂度为O(log (m+n))，看到这个时间复杂度，
     * 自然而然的想到了应该使用二分查找法来求解。但是这道题被定义为Hard也是有其原因的，难就难在要
     * 在两个未合并的有序数组之间使用二分法，如果这道题只有一个有序数组，让我们求中位数的话，估计
     * 就是个Easy题。那么我们可以将两个有序数组混合起来成为一个有序数组再做吗，图样图森破，这个时
     * 间复杂度限制的就是告诉你金坷垃别想啦。那么我们还是要用二分法，而且是在两个数组之间使用，感
     * 觉很高端啊。那么回顾一下中位数的定义，如果某个有序数组长度是奇数，那么其中位数就是最中间那
     * 个，如果是偶数，那么就是最中间两个数字的平均值。这里对于两个有序数组也是一样的，假设两个有
     * 序数组的长度分别为m和n，由于两个数组长度之和 m+n 的奇偶不确定，因此需要分情况来讨论，对于
     * 奇数的情况，直接找到最中间的数即可，偶数的话需要求最中间两个数的平均值。为了简化代码，不
     * 分情况讨论，我们使用一个小trick，我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求
     * 其平均值即可，这对奇偶数均适用。加入 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2
     * 的值相等，相当于两个相同的数字相加再除以2，还是其本身。
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查找的值：");
        int target = scanner.nextInt();
        int arr1[] = {1,2};
        int arr2[] = {3,4};
        double med= findMedianSortedArrays(arr1,arr2);
        System.out.println(med);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        if(total%2==0){
            return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
        }else{
            return findKth(total/2+1, nums1, nums2, 0, 0);
        }
    }

    public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2) {
        if (s1 >= nums1.length)
            return nums2[s2 + k - 1];
        if (s2 >= nums2.length)
            return nums1[s1 + k - 1];
        if (k == 1)
            return Math.min(nums1[s1], nums2[s2]);
        int m1 = s1 + k / 2 - 1;
        int m2 = s2 + k / 2 - 1;
        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return findKth(k - k / 2, nums1, nums2, m1 + 1, s2);
        } else {
            return findKth(k - k / 2, nums1, nums2, s1, m2 + 1);
        }
    }
}
