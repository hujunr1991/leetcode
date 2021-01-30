package month2101;

import java.util.Stack;

public class Problem190108 {
    /**
     * 递归实现
     * 关键就在于把大问题转化为子问题即可
     *
     * @param root
     */
    public static void Mirror1(TreeNode root) {
        if ((root == null) || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror1(root.left);
        Mirror1(root.right);
    }

    /**
     * 基于栈的DFS来遍历
     */

    /**
     * 非递归实现, 借助栈或者列表遍历树中每一个非叶子节点
     * 交换其左右子树即可
     * @param root
     */
    public static void Mirror2(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
    }
}
