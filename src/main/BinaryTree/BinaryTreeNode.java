package main.BinaryTree;

public class BinaryTreeNode<T> {
    /*
     * Class created by João Branco and Vitor Soller
     * Repository can be viewed at https://github.com/JoaoVitorBranco/data_structures_ECM306
     */
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void add(T value){
        if(this.left == null){
            this.left = new BinaryTreeNode<T>(value);
        }
        else if(this.right == null){
            this.right = new BinaryTreeNode<T>(value);
        }
        else{
            this.left.add(value);
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
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
