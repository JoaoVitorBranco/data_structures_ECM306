package main.BinaryTree;

public class BinaryTree {
    private BinaryTreeNode root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public BinaryTree(int value) {
        this.root = new BinaryTreeNode(value);
        this.size = 1;
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
        setSizeBasedInNode(this.root);
    }

    public BinaryTree(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.root = new BinaryTreeNode(value, left, right);
        setSizeBasedInNode(this.root);
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.size = 0;
        setSizeBasedInNode(root);
        this.root = root;
    }

    private void setSizeBasedInNode(BinaryTreeNode node) {
        if (node != null) {
            this.size++;
            setSizeBasedInNode(node.getLeft());
            setSizeBasedInNode(node.getRight());
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String posOrder(BinaryTreeNode node) {
        String left = "";
        String right = "";
        if (node != null) {
            left = posOrder(node.getLeft());
            right = posOrder(node.getRight());
            return left + right + node.getValue() + " ";
        }
        return "";
    }

    public String posOrder(){
        return posOrder(this.root);
    }

    public String preOrder(BinaryTreeNode node) {
        String left = "";
        String right = "";
        if (node != null) {
            left = preOrder(node.getLeft());
            right = preOrder(node.getRight());
            return node.getValue() + " " + left + right;
        }
        return "";
    }

    public String preOrder(){
        return preOrder(this.root);
    }

    public String inOrder(BinaryTreeNode node) {
        String left = "";
        String right = "";
        if (node != null) {
            left = inOrder(node.getLeft());
            right = inOrder(node.getRight());
            return left + node.getValue() + " " + right;
        }
        return "";
    }

    public String inOrder(){
        return inOrder(this.root);
    }

    public int getHeight(BinaryTreeNode node) {
        if (node != null) {
            int left = getHeight(node.getLeft());
            int right = getHeight(node.getRight());
            return Math.max(left, right) + 1;
        }
        return -1;
    }

    public int getHeight(){
        return getHeight(this.root);
    }

    public boolean isFull() {
        return this.size == Math.pow(2, getHeight() + 1) - 1;
    }

    public boolean contains(int value) {
        return contains(this.root, value);
    }

    private boolean contains(BinaryTreeNode node, int value) {
        if (node != null) {
            if (node.getValue() == value) {
                return true;
            }
            return contains(node.getLeft(), value) || contains(node.getRight(), value);
        }
        return false;
    }
}
