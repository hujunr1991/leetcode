package month2104;

/**
 * 数组中的逆序对------考察归并排序
 */
public class Problem360406 {

    int count = 0;


    /**
     * 这个时候就当你会了归并排序了。当进行合并操作的时候，如果nums[p1]>nums[p2]的话，
     * 那么这个时候就组成逆序对。然后就是nums[p1]~nums[mid]都大于nums[p2]，所以此时的逆序对数就是mid-p1+1。
     */
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    //归并排序
    public void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) >> 1);
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            //合并操作
            merge(nums, start, mid, end);
        }
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= end) {
            if (nums[p1] <= nums[p2]) {
                temp[p++] = nums[p1++];
            } else {
                //此时就是nums[p1]>nums[p2]的时候，组成逆序对
                //数量是mid-p1+1
                count = count + mid - p1 + 1;
                temp[p++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            temp[p++] = nums[p1++];
        }
        while (p2 <= end) {
            temp[p++] = nums[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i + start] = temp[i];
        }
    }

    public static void main(String[] args) {
        Problem360406 p = new Problem360406();
        int[] array = {7,6,5,4};
        int i = p.reversePairs(array);
        System.out.println(i);
    }
}
