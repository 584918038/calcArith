package com.calc.review.binary2tree;

/**
 * @author xuenhan
 */
public class BinaryTree {

    /**
     *           10
     *        9     20
     *            15  35
     */
    public static void main(String[] args) {

        // 初始化节点
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(35);

        node1.setLeft(node2);
        node1.setRight(node3);

        node3.setLeft(node4);
        node3.setRight(node5);

        // 前序遍历
        preTraverseBtree(node1);

        System.out.println("--------------");
        // 中序遍历
        inTraverseBtree(node1);

        // 后序遍历
        System.out.println("--------------");
        postOrderBtree(node1);

        // 动态创建二叉树

        int[] arrays = {2, 3, 1, 4, 5};

        //动态创建树
        TreeRoot root = new TreeRoot();
        for (int value : arrays) {
            createTree(root, value);
        }

        //先序遍历树
        preTraverseBtree(root.getTreeRoot());
        System.out.println("---------------公众号：Java3y");

        //中序遍历树
        inTraverseBtree(root.getTreeRoot());
        System.out.println("---------------公众号：Java3y");

    }

    /**
     * 前序遍历: 根左右
     */
    public static void preTraverseBtree(TreeNode root) {

        if (root != null) {
            // 根
            System.out.println(root.getValue());
            // 左
            preTraverseBtree(root.getLeft());
            // 右
            preTraverseBtree(root.getRight());
        }
    }

    /**
     * 中序遍历: 左根右
     *
     * @param root 根节点
     */
    public static void inTraverseBtree(TreeNode root) {

        if (null != root) {

            // 左
            inTraverseBtree(root.getLeft());

            // 根
            System.out.println(root.getValue());

            // 右
            inTraverseBtree(root.getRight());
        }
    }

    /**
     * 后序遍历: 左右根
     * @param root 根节点
     */
    public static void postOrderBtree(TreeNode root) {

        if (null != root) {
            // 左
            postOrderBtree(root.getLeft());

            // 右
            postOrderBtree(root.getRight());

            // 根
            System.out.println(root.getValue());
        }
    }

    /**
     * 动态创建二叉查找树
     * @param treeRoot 根结点
     * @param value 节点的值
     */
    public static void createTree(TreeRoot treeRoot, int value) {

        if (null == treeRoot.getTreeRoot()) {

            TreeNode root = new TreeNode(value);
            treeRoot.setTreeRoot(root);

        } else {

            TreeNode root = treeRoot.getTreeRoot();

            while (null != root) {

                // 当前值大于根值，往右边走
                if (value > root.getValue()) {

                    // 右边没有值，则直接插入
                    if (null == root.getRight()) {

                        root.setRight(new TreeNode(value));
                        return;
                    } else {
                        // 如果右边有值，则递归进去
                        root = root.getRight();
                    }
                } else {

                    if (null == root.getLeft()) {

                        root.setLeft(new TreeNode(value));
                        return;
                    } else {
                        // 如果左子树存在则递归进去
                        root = root.getLeft();
                    }
                }
            }
        }

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

class TreeRoot {

    private TreeNode treeRoot;

    public TreeNode getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeNode treeRoot) {
        this.treeRoot = treeRoot;
    }
}


