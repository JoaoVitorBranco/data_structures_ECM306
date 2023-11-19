package main.BinarySearchTree;

public class BinarySearchTreeNode {
    private int value;
    private BinarySearchTreeNode parent;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public BinarySearchTreeNode(int value){
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public BinarySearchTreeNode(int value, BinarySearchTreeNode parent, BinarySearchTreeNode left, BinarySearchTreeNode right){
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinarySearchTreeNode getParent() {
        return this.parent;
    }

    public void setParent(BinarySearchTreeNode parent) {
        this.parent = parent;
    }

    public BinarySearchTreeNode getLeft() {
        return this.left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return this.right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }
 
    public int add(int value){
        if(value < this.getValue()){
            if(this.getLeft() == null){
                this.setLeft(new BinarySearchTreeNode(value));
                this.getLeft().setParent(this);
                return 1;
            }
            else{
                return this.getLeft().add(value);
            }
        }
        else if(value > this.getValue()){
            if(this.getRight() == null){
                this.setRight(new BinarySearchTreeNode(value));
                this.getRight().setParent(this);
                return 1;
            }
            else{
                return this.getRight().add(value);
            }
        }
        else{
            return 0;
        }
    }

    public void preOrder(){
        System.out.print(this.value + " ");
        if(this.getLeft() != null){
            this.getLeft().preOrder();
        }
        if(this.getRight() != null){
            this.getRight().preOrder();
        }
    }

    public void posOrder(){
        if(this.getLeft() != null){
            this.getLeft().posOrder();
        }
        if(this.getRight() != null){
            this.getRight().posOrder();
        }
        System.out.print(this.value + " ");
    }

    public void inOrder(){
        if(this.getLeft() != null){
            this.getLeft().inOrder();
        }
        System.out.print(this.value + " ");
        if(this.getRight() != null){
            this.getRight().inOrder();
        }
    }

    public void printChildren(){
        if(this.getLeft() != null){
            System.out.print(this.getLeft().getValue() + "\t");
        }
        else{
            System.out.print("\t");
        }

        if(this.getRight() != null){
            System.out.println(this.getRight().getValue());
        }
    }

    public boolean isIn(int value){
        if(this.getValue() == value){
            return true;
        }
        if(value <= this.getValue()){
            if(this.getLeft() == null){
                return false;
            }
            else{
                return this.getLeft().isIn(value);
            }
        }
        else{
            if(this.getRight() == null){
                return false;
            }
            else{
                return this.getRight().isIn(value);
            }
        }
    }

    public int bigger(){
        if(this.right == null){
            return this.value;
        }
        else{
            return this.right.bigger();
        }
    }

    public int smaller(){
        if(this.left == null){
            return this.value;
        }
        else{
            return this.left.smaller();
        }
    }

    public int sum(){
        int total = this.value;
        if(this.left != null){
            total += this.left.sum();
        }
        if(this.right != null){
            total += this.right.sum();
        }
        return total;
    }

    public int nullCount(){
        int value = 0;
        if(this.left != null){
            value += this.left.nullCount();
        }
        else{
            value += 1;
        }
        if(this.right != null){
            value += this.right.nullCount();
        }
        else{
            value += 1;
        }
        return value;
    }

    public boolean isLeaf(){
        return (this.right == null && this.left == null);
    }

    public int leafsCount(){
        if(this.isLeaf()){
            return 1;
        }
        else{
            int num_of_leafs = 0;
            if(this.left != null){
                num_of_leafs += this.left.leafsCount();
            }
            if(this.right != null){
                num_of_leafs += this.right.leafsCount();
            }
            return num_of_leafs;
        }
    }

    public int height(){
        if(this.right != null && this.left != null){
            int leftHeight = this.left.height();
            int rightHeight = this.right.height();
            if(rightHeight >= leftHeight){
                return rightHeight+ 1;
            }
            else{
                return leftHeight + 1;
            }
        }
        else if(this.right != null){
            return this.right.height() + 1;
        }
        else if(this.left != null){
            return this.left.height() + 1;
        }
        else{
            return 0;
        }
    }

    public int getTwoMultiples(){
        int value = this.value % 2 == 0 ? 1 : 0;
        if(this.left != null){
            value += this.left.getTwoMultiples();
        }
        if(this.right != null){
            value += this.right.getTwoMultiples();
        }
        return value;
    }

    public int pop(int value){
        return -1;
    }

    public BinarySearchTreeNode getNode(int value){
        if(this.getValue() == value){
            return this;
        }
        if(value < this.getValue()){
            if(this.getLeft() == null){
                return null;
            }
            else{
                return this.getLeft().getNode(value);
            }
        }
        else{
            if(this.getRight() == null){
                return null;
            }
            else{
                return this.getRight().getNode(value);
            }
        }
    }
}
