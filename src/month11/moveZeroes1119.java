package month11;

public class moveZeroes1119 {

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param nums
     */
















    public void moveZeroes(int[] nums) {
        //定义下标不为0的j
        int j = 0;
        for(int i = 0; i < nums.length;i++) {
            if (nums[i] !=0) {
                //从j找不为0的元素
                nums[j] = nums[i];
                //剔除[1]一个元素的情况
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }

    }


}
