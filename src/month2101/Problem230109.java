package month2101;

import month12.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem230109 {
    /**
     * 二叉树层序遍历
     */

    public static void printFromTopToBottom(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }


    //前序遍历--递归
    private void preOrder(TreeNode node){
        if(node == null)
            return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序遍历--非递归,借助栈实现
    private void preOrderNR(TreeNode node){
        if(node == null)
            return;
        System.out.println(node.val);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop);
            if (pop.right !=null) {
                stack.push(pop.right);
            }
            if (pop.left !=null) {
                stack.push(pop.left);
            }
        }
    }

    //中序遍历--递归
    private void inOrder(TreeNode node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }


    //中序遍历--费递归，借助栈
    private void inOrderNR(TreeNode node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }



}