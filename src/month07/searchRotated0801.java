package month07;


public class searchRotated0801 {


    /*
    【033-Search in Rotated Sorted Array（在旋转数组中搜索）】
    先在数组中找到最小元素对应的下标，如果下标为0说明整个数组是序的，
    如果不是说明数组被分成两个有序的区间，判断要查找的元素是那一个有序区间中，
    然后进行查找。
     */

    public static int search(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            //找到最小的数组下标
            int minIndex = searchMinIndex(nums, 0, nums.length - 1);
            // 整个数组全局有序
            if (minIndex == 0) {
                return binarySearch01(nums, 0, nums.length - 1, target);
            }
            // 有两个局部有序区间,  如 4 5 6 7 8 9 0 1 2 3
            else {
                // 恬好和后一个有序区间的最后一个元素相等，返回对应的下标
                if (nums[nums.length - 1] == target) {
                    return nums.length - 1;
                }
                // target可能在后一个有序区间中
                else if (nums[nums.length - 1] > target) {
                    return binarySearch01(nums, minIndex+1, nums.length - 1, target);
                }
                // target可能是前一个有序区间中
                else {
                    return binarySearch01(nums, 0, minIndex - 1, target);
                }
            }



        }
        return -1;

    }

    private static int searchMinIndex(int[] nums, int low, int high) {
        int mid;
        while (low < high) {
            mid = low + (high-low)/2;
            // 后一个数比前个数小就找到了
            if (nums[mid] > nums[mid+1]) {
                return mid;
            }
            // 说明中间值在第一个有序的数组中
            else if (nums[mid] >nums[low]) {
                low = mid;
            } else {
                high =mid;
            }
        }
        // 说明整个数组是有序的
        return 0;

    }

    private static int binarySearch01(int[] nums, int low, int high, int target) {

        int mid;
        while (low <= high) {
            mid = low + (high-low)/2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    //第二种解法
    private static int search01(int[] nums, int target) {
            int left=0;
            int right=nums.length-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<nums[right]){//如果nums[mid]<nums[right]则说明右侧的排序是有序的，没有出现扰乱点
                    if(nums[mid]<target&&target<=nums[right]){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }else{//这种情况是mus[mid]>=nums[right]则说明左边的排序是有序的，没有出现扰乱点
                    if(nums[mid]>target&&nums[left]<=target){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }
            }
            return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 6));
        System.out.println("=====");
        System.out.println(search01(nums, 6));
    }

}
