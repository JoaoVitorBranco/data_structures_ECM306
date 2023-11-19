package main.BinarySearchTree;

public class BinarySearchTree{
    /*
     * Class created by João Branco and Vitor Soller
     * Repository can be viewed at https://github.com/JoaoVitorBranco/data_structures_ECM306
     *
     * Métodos
     * public BinarySearchTree()
     * public BinarySearchTree(BinarySearchTreeNode root)
     * public BinarySearchTree(int[] arr)
     * public void add(int value)
     * public int getLength() 
     * public BinarySearchTreeNode getRoot() 
     * public void setRoot(BinarySearchTreeNode root) 
     * public void preOrder()
     * public void posOrder()
     * public void inOrder()
     * public boolean isIn(int value)
     * public int bigger()
     * public int smaller()
     * public double mean()
     * public int nullCount()
     * public int leafsCount()
     * public int height()
     * public int getHeight()
     * public int getTwoMultiples()
     * public int getSum()
     * public int pop(int value)
     *
     * Depth -> Profundidade
     *      - tamanho da raiz até o nó
     *
     * Height -> Altura
     *      - tamanho do nó até o nó de nível mais baixo
     *
     * TreeHeight -> Altura da árvore
     *      - altura da raiz
     *
     * Empty -> Vazia
     *      - árvore vazia
     *
     * Propper -> Própria
     *     - SEMPRE tem 0 ou 2 filhos
     *
     * Impropper -> Imprópria
     *      - Pelo menos um nó tem APENAS 1 filho
     *
     * minNodeCount -> Número mínimo de nós
     *      - Menor quantidade de nós que uma árvore pode ter
     *      - n = h + 1
     *
     * maxNodeCount -> Número máximo de nós
     *     - Maior quantidade de nós que uma árvore pode ter
     *    - n = 2^(h+1) - 1
     *
     */


    private int length;
    private BinarySearchTreeNode root;

    public BinarySearchTree(){
        this.length = 0;
        this.root = null;
    }

    public BinarySearchTree(BinarySearchTreeNode root){
        this.length = 1;
        this.root = root;
    } 

    public BinarySearchTree(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            this.add(arr[i]);
        }
    }

    public void add(int value){
        int returned = 1;
        if(this.root != null){
            returned = this.root.add(value);
            
        }
        else{
            this.root = new BinarySearchTreeNode(value);
        }
        if(returned == 1){
            this.length++;
        }
    }

    public int getLength() {
        return this.length;
    }

    public BinarySearchTreeNode getRoot() {
        return this.root;
    }

    public void setRoot(BinarySearchTreeNode root) {
        if (this.root == null){
            this.root = root;
        }
        else{
            System.out.println("Não pode modificar, a árvore já tem raiz");
        }
    }

    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
            System.out.println();
        }
        else{
            System.out.println("Árvore vazia");
        }
    }

    public void posOrder(){
        if(this.root != null){
            this.root.posOrder();
            System.out.println();
        }
        else{
            System.out.println("Árvore vazia");
        }
    }
    
    public void inOrder(){
        if(this.root != null){
            this.root.inOrder();
            System.out.println();
        }
        else{
            System.out.println("Árvore vazia");
        }

    }
    
    public boolean isIn(int value){
        if(this.root == null){
            return false;
        }
        return this.root.isIn(value);
    }

    public int bigger(){
        return this.root.bigger();
    }

    public int smaller(){
        return this.root.smaller();
    }

    public double mean(){
        return this.root.sum()*1.0/this.length;        
    }

    public int nullCount(){
        return this.root.nullCount();
    }

    public int leafsCount(){
        return this.root.leafsCount();
    }

    public int height(){
        return this.root.height();
    }

    public int getHeight(){
        return this.root.height();
    }

    public int getTwoMultiples(){
        return this.root.getTwoMultiples();
    }

    public int getSum(){
        return this.root.sum();
    }

    private BinarySearchTreeNode getNode(int value){
        if(this.root != null){
            return this.root.getNode(value);
        }
        else{
            System.out.println("Árvore vazia");
            return null;
        }
    }

    public int pop(int value){
        BinarySearchTreeNode node = this.getNode(value);
        int returned = value;
        if(node == null){
            returned = -1;
        }
        else{ 
            if(node.isLeaf()){ // case 1: node is leaf
                BinarySearchTreeNode parent = node.getParent();
                if(parent == null){
                    this.root = null;
                }
                else{
                    if(parent.getLeft() == node){
                        parent.setLeft(null);
                    }
                    else{
                        parent.setRight(null);
                    }
                }
                this.length--;
            }
            else if(node.getLeft() != null && node.getRight() == null){ // case 2A: node just have a left child
                if(node.getParent() == null){
                    this.root = node.getLeft();
                }
                else{
                    if(node.getParent().getLeft() == node){
                        node.getParent().setLeft(node.getLeft());
                    }
                    else{
                        node.getParent().setRight(node.getLeft());
                    }
                    node.getLeft().setParent(node.getParent());
                }
                this.length--;
            }
            else if(node.getLeft() == null && node.getRight() != null){ // case 2B: node just have a right child
                if(node.getParent() == null){
                    this.root = node.getRight();
                }
                else{
                    if(node.getParent().getLeft() == node){
                        node.getParent().setLeft(node.getRight());
                    }
                    else{
                        node.getParent().setRight(node.getRight());
                    }
                    node.getRight().setParent(node.getParent());
                }
                this.length--;
            }
            else{ // case 3: node have two children
                BinarySearchTreeNode smaller = node.getRight().getSmaller();
                BinarySearchTreeNode smallersParent = smaller.getParent();
                BinarySearchTreeNode smallersRightChild = smaller.getRight();
                BinarySearchTreeNode nodeParent = node.getParent();

                smaller.setLeft(node.getLeft());
                if(smallersParent == node){
                    node.getLeft().setParent(smaller);
                }
                else{
                    smallersParent.setLeft(smallersRightChild);
                    if(smallersRightChild != null){
                        smallersRightChild.setParent(smallersParent);
                    }
                    smaller.setRight(node.getRight());

                }

                if(nodeParent == null){
                    this.root = smaller;
                }
                else if(nodeParent.getLeft() == node){
                    nodeParent.setLeft(smaller);
                }
                else{
                    nodeParent.setRight(smaller);
                }
                smaller.setParent(nodeParent);
                this.length--;
            }
        }
        return returned;
    }
}