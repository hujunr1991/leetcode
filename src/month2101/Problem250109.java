package month2101;

import java.util.Stack;

public class Problem250109 {

    /**
     * 这是一道DFS题目，也可以看做是先序遍历的题目 ,在二叉树中，dfs就相当于先序遍历
     * 首先，采用一种“减法”思想，当检查一棵树从根到叶子节点形成的路径的和是否为target时，先将当前根节点的值 root.val 加入path, 然后检查它的左子树（若非空），看从左子树的根到叶子节点形成的路径的和是否为 target - root.val (递归), 然后同样的道理去递归检查右子树（若非空），这便是大致的思路。
     * 但这道题麻烦的一点是，它要求记录下所有符合标准的路径，这便用到了dfs的特性。
     * 但又来了一件麻烦事，先序遍历便是先左后右。检查完左子树后，会对path就行修改，再去查找右子树，如何将path恢复到之前未进行左子树检查的状态？
     *
     * 很明显，借助栈的思想
     */

    public void findpath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int currentSum = 0;
        findpathChirder(root, sum, stack, currentSum);
    }

    private void findpathChirder(TreeNode root, int sum, Stack<Integer> stack, int currentSum) {

        currentSum += root.val;
        stack.push(root.val);

        if (root.left == null && root.right == null) {
            if (sum == currentSum) {
                System.out.println("找到一个路径");
                for (int path : stack) {
                    System.out.println(path + "");
                }
                System.out.println();
            }
        }
        if(root.left!=null){
            findpathChirder(root.left, sum, stack, currentSum);
        }
        if(root.right!=null){
            findpathChirder(root.right, sum, stack, currentSum);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        root.val=10;
        node1.val=5;
        node2.val=12;
        node3.val=4;
        node4.val=7;
        Problem250109 problem250109 = new Problem250109();
        problem250109.findpath(root, 22);
    }

}
