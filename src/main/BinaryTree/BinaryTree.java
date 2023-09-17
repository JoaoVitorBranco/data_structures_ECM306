package main.BinaryTree;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public BinaryTree(T value) {
        this.root = new BinaryTreeNode<T>(value);
        this.size = 1;
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
        setSizeBasedInNode(this.root);
    }

    public BinaryTree(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.root = new BinaryTreeNode<T>(value, left, right);
        setSizeBasedInNode(this.root);
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.size = 0;
        setSizeBasedInNode(root);
        this.root = root;
    }

    private void setSizeBasedInNode(BinaryTreeNode<T> node) {
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

    public String posOrder(BinaryTreeNode<T> node) {
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

    public String preOrder(BinaryTreeNode<T> node) {
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

    public String inOrder(BinaryTreeNode<T> node) {
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

    public int getHeight(BinaryTreeNode<T> node) {
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

    public boolean contains(T value) {
        return contains(this.root, value);
    }

    public boolean contains(BinaryTreeNode<T> node, T value) {
        if (node != null) {
            if (node.getValue() == value) {
                return true;
            }
            return contains(node.getLeft(), value) || contains(node.getRight(), value);
        }
        return false;
    }

    // public int getMax() {
    //     return getMax(this.root);
    // }

    // public int getMax(BinaryTreeNode<T> node) {
    //     if (node != null) {
    //         int left = getMax(node.getLeft());
    //         int right = getMax(node.getRight());
    //         return Math.max(node.getValue(), Math.max(left, right));
    //     }
    //     return Integer.MIN_VALUE;
    // }

    // public int getMin() {
    //     return getMin(this.root);
    // }

    // public int getMin(BinaryTreeNode<T> node) {
    //     if (node != null) {
    //         int left = getMin(node.getLeft());
    //         int right = getMin(node.getRight());
    //         return Math.min(node.getValue(), Math.min(left, right));
    //     }
    //     return Integer.MAX_VALUE;
    // }

    // public double getAverage() {
    //     return getAverage(this.root);
    // }

    // public double getAverage(BinaryTreeNode<T> node) {
    //     int left = getSum(node.getLeft());
    //     int right = getSum(node.getRight());
    //     return (double) (node.getValue() + left + right) / this.size;
    // }

    // public int getSum() {
    //     return getSum(this.root);
    // }

    // public int getSum(BinaryTreeNode node) {
    //     if (node != null) {
    //         int left = getSum(node.getLeft());
    //         int right = getSum(node.getRight());
    //         return node.getValue() + left + right;
    //     }
    //     return 0;
    // }

    public int getLeafCount() {
        return getLeafCount(this.root);
    }

    public int getLeafCount(BinaryTreeNode<T> node) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                return 1;
            }
            int left = getLeafCount(node.getLeft());
            int right = getLeafCount(node.getRight());
            return left + right;
        }
        return 0;
    }

    public int getInternalNodeCount() {
        return getInternalNodeCount(this.root);
    }

    public int getInternalNodeCount(BinaryTreeNode<T> node) {
        if (node != null) {
            if (node.getLeft() != null || node.getRight() != null) {
                return 1 + getInternalNodeCount(node.getLeft()) + getInternalNodeCount(node.getRight());
            }
        }
        return 0;
    }

    public int getNullNodeCount() {
        return getNullNodeCount(this.root);
    }

    public int getNullNodeCount(BinaryTreeNode<T> node) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                return 2;
            } else if (node.getLeft() == null || node.getRight() == null) {
                return 1;
            }
            return getNullNodeCount(node.getLeft()) + getNullNodeCount(node.getRight());
        }
        return 0;
    }



}
