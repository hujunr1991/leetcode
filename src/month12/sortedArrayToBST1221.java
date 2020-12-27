package month12;

public class sortedArrayToBST1221 {


    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。--108题
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * 中序遍历的输出为有序数组，只想到了这个
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper(nums, left, mid-1);
        treeNode.right = helper(nums, mid+1, right);
        return treeNode;
    }
}



