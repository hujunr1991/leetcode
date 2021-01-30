package month2101;

import month12.TreeNode;

import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e) {

        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序遍历--非递归,借助栈实现，

    /**
     * 步骤
     * 1、根节点入栈
     * 2、输出根节点，依次入右节点和左节点
     */
    private void preOrderNR(){
        if(root == null)
            return;
        System.out.println(root.e);
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop);
            if (pop.right !=null) {
                stack.push(pop.right);
            }
            if (pop.left !=null) {
                stack.push(pop.left);
            }
        }
    }

    // 二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 中序遍历以node为根的二分搜索树, 非递归算法,借助栈，依次让左树入栈，出栈的时候在将右子树入栈，在出栈右子树，在到根节点

    /**
     * 步骤
     * 1、先从根节点到左节点依次入栈
     * 2、之后左节点的最后一个元素出栈，到右节点的左子树出栈，把右节点入栈，之后在出栈
     * 3、最后到根节点---右子树
     */
    private void inOrderNR() {
        if (root == null) return;
        Stack<Node> s = new Stack<>();
        Node node = root;
        while (node != null || s.size() > 0) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                System.out.print(node.e + "  ");
                node = node.right;
            }
        }

    }


    // 二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

        bst.inOrder();
        bst.inOrderNR();
        System.out.println();

        bst.postOrder();
        System.out.println();
    }
}
