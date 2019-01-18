/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package array_2018_12_5;

import java.util.Scanner;

/**
 * description
 *寻找旋转有序数组中的目标值
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2018/12/07 14:17
 * @since 1.0
 */
public class SearchRotatedArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查找的值：");
        int target = scanner.nextInt();
        int arr[] = {4,5,6,7,0,1,2};
        int index = search(arr,target);
        System.out.println(index);

    }

    /**
     * （1）如果target==A[m]，那么m就是我们要的结果，直接返回；
     * （2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在m到r之间，如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
     * （3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。
     * 根据以上方法，每次我们都可以切掉一半的数据，所以算法的时间复杂度是O(logn)，空间复杂度是O(1)。代码如下：
     */
 private static int search(int nums[],int target){
     int l = 0, r = nums.length-1;
     while (l<=r) {
         int mid = (r-l)/2+l;
         if (nums[mid] == target)
             return mid;
         if (nums[mid] < nums[r]) {
             if (nums[mid]<target && target<=nums[r])
                 l = mid+1;
             else
                 r = mid-1;
         } else {
             if(nums[l]<=target && target<nums[mid])
                 r = mid-1;
             else
                 l = mid+1;
         }
     }
     return -1;
 }
}
