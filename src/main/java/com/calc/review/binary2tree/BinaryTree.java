package com.calc.review.binary2tree;

/**
 *
 * @author xuenhan
 */
public class BinaryTree {

    /**
     *               10
     *            9     20
     *                15  35
     *
     */
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(35);

        node1.setLeft(node2);
        node1.setRight(node3);

        node3.setLeft(node4);
        node3.setRight(node5);

    }
}


class TreeNode {

    private TreeNode left;

    private TreeNode right;

    private int value;

    public TreeNode(int value) {

        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
