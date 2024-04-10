package com.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTree {
    // 根节点
    private TreeNode root;

    // 构造函数
    public BinaryTree() {
        root = null;
    }

    // 插入节点
    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    // 递归插入节点
    private TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.val)
            root.left = insertRecursive(root.left, val);
        else if (val > root.val)
            root.right = insertRecursive(root.right, val);
        return root;
    }

    // 前序遍历
    public void preOrderTraversal() {
        preOrderTraversalRecursive(root);
    }

    private void preOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraversalRecursive(root.left);
            preOrderTraversalRecursive(root.right);
        }
    }

    // 中序遍历
    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            System.out.print(root.val + " ");
            inOrderTraversalRecursive(root.right);
        }
    }

    // 后序遍历
    public void postOrderTraversal() {
        postOrderTraversalRecursive(root);
    }

    private void postOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            postOrderTraversalRecursive(root.left);
            postOrderTraversalRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }

    // 层序遍历
    public void levelOrderTraversal() {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    // 逆层序遍历
    public void reverseLevelOrderTraversal() {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            stack.push(temp);
            if (temp.right != null)
                queue.add(temp.right);
            if (temp.left != null)
                queue.add(temp.left);
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.val + " ");
        }
    }

    // 输出树的高度
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = heightRecursive(root.left);
        int rightHeight = heightRecursive(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("前序遍历:");
        tree.preOrderTraversal();
        System.out.println("\n中序遍历:");
        tree.inOrderTraversal();
        System.out.println("\n后序遍历:");
        tree.postOrderTraversal();
        System.out.println("\n层序遍历:");
        tree.levelOrderTraversal();
        System.out.println("\n逆层序遍历:");
        tree.reverseLevelOrderTraversal();
        System.out.println("\n树的高度: " + tree.height());
    }
}

