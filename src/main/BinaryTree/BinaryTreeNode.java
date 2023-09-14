package main.BinaryTree;

public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode() {
        this.value = 0;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public boolean hasLeft(){
        return this.left != null;
    }

    public boolean hasRight(){
        return this.right != null;
    }

    public boolean isLeaf(){
        return !this.hasLeft() && !this.hasRight();
    }

    public boolean hasOneChild(){
        return (this.hasLeft() && !this.hasRight()) || (!this.hasLeft() && this.hasRight());
    }

    public boolean hasTwoChildren(){
        return this.hasLeft() && this.hasRight();
    }

    public boolean hasChildren(){
        return this.hasLeft() || this.hasRight();
    }

    public String toString(){
        return String.valueOf(this.value);
    }
}
