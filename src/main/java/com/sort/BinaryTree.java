package com.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树基本操作及遍历
 * 二叉树基本结构
 * 二叉树的基本操作包括插入、查找和删除等。为了使操作更直观，下面是一棵简单的二叉树，演示二叉树的结构和操作：
 *
 * markdown
 * Copy code
 *        10
 *      /    \
 *     5      15
 *    / \    /  \
 *   2   7  12  17
 * 在这棵二叉树中：
 *
 * 每个节点可以有最多两个子节点。
 * 左子树的值小于父节点，右子树的值大于父节点。
 * 插入操作
 * 插入操作将一个新节点插入到二叉树的正确位置。根据二叉搜索树的规则，较小的值插入左子树，较大的值插入右子树。
 *
 * markdown
 * Copy code
 *        10
 *      /    \
 *     5      15
 *    / \    /  \
 *   2   7  12  17
 *            \
 *             14
 * 在上面的插入操作中，数字 14 被插入到 12 的右子树，因为它大于 12 而小于 15。
 *
 * 查找操作
 * 查找操作用于在二叉树中查找特定值。如果找到了该值，则返回对应节点；如果没有找到，则返回空。
 *
 * 在上面的二叉树中，查找 7 的过程如下：
 *
 * 从根节点 10 开始，7 小于 10，所以转到左子树。
 * 在左子树中，7 大于 5，所以转到右子树。
 * 在右子树中，找到 7。
 * 删除操作
 * 删除操作用于删除二叉树中的节点。删除过程可能涉及到调整树的结构，以保持二叉搜索树的性质。
 *
 * 在删除节点 5 时，下面是调整后的二叉树：
 *
 * markdown
 * Copy code
 *        10
 *      /    \
 *     7      15
 *    /      /  \
 *   2     12  17
 *            \
 *             14
 * 删除操作要考虑三种情况：
 *
 * 节点没有子节点：直接删除节点。
 * 节点有一个子节点：将该子节点连接到父节点。
 * 节点有两个子节点：找到右子树的最小节点，替换待删除的节点，然后删除该最小节点。
 * 二叉树的遍历
 * 二叉树的遍历是按照特定顺序访问树中的每个节点。主要有三种遍历方式：前序、中序和后序。
 *
 * 前序遍历
 * 前序遍历先访问父节点，然后递归访问左子树，最后递归访问右子树。前序遍历的顺序是：根 -> 左 -> 右。
 *
 * 对于上面的二叉树，前序遍历的结果是：
 *
 * rust
 * Copy code
 * 10 -> 5 -> 2 -> 7 -> 15 -> 12 -> 14 -> 17
 * 中序遍历
 * 中序遍历先递归访问左子树，然后访问父节点，最后递归访问右子树。中序遍历的顺序是：左 -> 根 -> 右。
 *
 * 对于上面的二叉树，中序遍历的结果是：
 *
 * rust
 * Copy code
 * 2 -> 5 -> 7 -> 10 -> 12 -> 14 -> 15 -> 17
 * 后序遍历
 * 后序遍历先递归访问左子树，然后递归访问右子树，最后访问父节点。后序遍历的顺序是：左 -> 右 -> 根。
 *
 * 对于上面的二叉树，后序遍历的结果是：
 *
 * rust
 * Copy code
 * 2 -> 7 -> 5 -> 14 -> 12 -> 17 -> 15 -> 10
 */
class TreeNode {
    int value;
    TreeNode left;  // 左子节点
    TreeNode right; // 右子节点

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    // 根节点
    private TreeNode root;

    // 插入新节点
    public void insert(int value) {
        root = insertRec(root, value); // 调用递归插入方法
    }

    private TreeNode insertRec(TreeNode node, int value) {
        if (node == null) { // 如果节点为空，创建新节点
            return new TreeNode(value);
        }

        // 将值插入到正确的子树中
        if (value < node.value) {
            node.left = insertRec(node.left, value); // 插入左子树
        } else {
            node.right = insertRec(node.right, value); // 插入右子树
        }

        return node; // 返回当前节点
    }

    // 查找节点
    public boolean search(int value) {
        return searchRec(root, value); // 调用递归查找方法
    }

    private boolean searchRec(TreeNode node, int value) {
        if (node == null) { // 节点为空，说明没有找到
            return false;
        }

        if (value == node.value) { // 如果找到值，返回 true
            return true;
        } else if (value < node.value) { // 在左子树中查找
            return searchRec(node.left, value);
        } else { // 在右子树中查找
            return searchRec(node.right, value);
        }
    }

    // 删除节点
    public void delete(int value) {
        root = deleteRec(root, value); // 调用递归删除方法
    }

    private TreeNode deleteRec(TreeNode node, int value) {
        if (node == null) { // 如果节点为空，说明找不到要删除的值
            return null;
        }

        if (value < node.value) { // 在左子树中删除
            node.left = deleteRec(node.left, value);
        } else if (value > node.value) { // 在右子树中删除
            node.right = deleteRec(node.right, value);
        } else {
            // 找到要删除的节点
            if (node.left == null) { // 没有左子节点，返回右子节点
                return node.right;
            } else if (node.right == null) { // 没有右子节点，返回左子节点
                return node.left;
            }

            // 节点有两个子节点，找到右子树中的最小节点
            TreeNode minNode = findMin(node.right);
            node.value = minNode.value; // 用最小节点的值替换当前节点
            node.right = deleteRec(node.right, minNode.value); // 删除右子树中的最小节点
        }

        return node; // 返回当前节点
    }

    // 查找右子树中的最小节点
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) { // 找到最左侧的节点
            node = node.left;
        }
        return node;
    }

    // 前序遍历
    public void preOrderTraversal() {
        preOrderTraversalRecursive(root);
    }

    private void preOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
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
            System.out.print(root.value + " ");
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
            System.out.print(root.value + " ");
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
            System.out.print(temp.value + " ");
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
            System.out.print(temp.value + " ");
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
       // 10 -> 5 -> 2 -> 7 -> 15 -> 12 -> 14 -> 17
        tree.insert(10);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(15);
        tree.insert(12);
        tree.insert(14);
        tree.insert(17);

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

