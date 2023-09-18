package main.Tree;

import java.util.ArrayList;

public class Node<T>{
    /*
     * Class created by João Branco and Vitor Soller
     * Repository can be viewed at https://github.com/JoaoVitorBranco/data_structures_ECM306
     */
    /*
     * Sibling -> irmão
     *      - nós filhos do mesmo pai
     * 
     * Father -> pai
     * 
     * Leafs -> nó externo / folha
     *      - nós sem filhos
     * 
     * Intern
     *      - nós com filhos (1 ou mais)
     * 
     * Ancestor -> ancestral
     *      - pai, avô, bisavô, ...
     * 
     * Downward -> Descendente
     *      -  filho, neto, bisneto, ...
     */

    /*
    * Node<T> getFather()
    * void setFather(Node<T> father)
    * T getValue()
    * void setValue(T value)
    * Node<T> getFirstChild()
    * void setFirstChild(Node<T> firstChild)
    * Node<T> getNextSibling()
    * void setNextSibling(Node<T> nextSibling)
    * void printChildren()
    * boolean isIntern()
    * boolean isLeaf()
    * void printLeafChildren()
    * ArrayList<T> getAllInternals()
    * ArrayList<T> getAllSiblings()
    * ArrayList<T> getAllAncestors()
    * ArrayList<T> getAllDownwards()
    * int getDepth()
    * int getHeight()
    * ArrayList<T> getAllChildren()
    */

    private Node<T> father;
    private T value;
    private Node<T> firstChild;
    private Node<T> nextSibling;

    public Node(T value){
        this.value = value;
        this.father = null;
        this.firstChild = null;
        this.nextSibling = null;
    }

    public Node(Node<T> father, T value){
        this.value = value;
        this.father = father;
        this.firstChild = null;
        this.nextSibling = null;
    }

    public Node(Node<T> father, T value, Node<T> firstChild, Node<T> nextSibling){
        this.value = value;
        this.father = father;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    public Node<T> getFather() {
        return this.father;
    }

    public void setFather(Node<T> father) {
        this.father = father;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getFirstChild() {
        return this.firstChild;
    }

    public void setFirstChild(Node<T> firstChild) {
        this.firstChild = firstChild;
    }

    public Node<T> getNextSibling() {
        return this.nextSibling;
    }

    public void setNextSibling(Node<T> nextSibling) {
        this.nextSibling = nextSibling;
    }
    
    public void printChildren(){
        System.out.print("[");
        if(this.firstChild == null){
            System.out.println("]");
            return ;
        }
        Node<T> aux = this.firstChild;
        System.out.print("" + String.valueOf(aux.getValue()));
        while(aux.getNextSibling() != null){
            aux = aux.getNextSibling();
            System.out.print(", " + String.valueOf(aux.getValue()));
        }
        System.out.println("]");
    }

    public boolean isIntern(){
        return this.getFather() != null && this.getFirstChild() != null;
    }

    public boolean isLeaf(){
        return this.firstChild == null;
    }

    public void printLeafChildren(){
        System.out.print("[");
        if(this.firstChild == null){
            System.out.println("]");
            return ;
        }
        Node<T> aux = this.firstChild;
        while(! aux.isLeaf()){
            aux = aux.getNextSibling();
            if(aux == null){
                System.out.println("]");
                return ;
            }
        }
        System.out.print("" + String.valueOf(aux.getValue()));
        while(aux.getNextSibling() != null){
            aux = aux.getNextSibling();
            System.out.print(", " + String.valueOf(aux.getValue()));
        }
        System.out.println("]");
    }

    public ArrayList<T> getAllInternals(){
        if(this.isLeaf()){
            return new ArrayList<T>();
        }
        ArrayList<T> intern = new ArrayList<T>();
        ArrayList<T> subarr;
        Node<T> aux = this.getFirstChild();
        while(aux != null){
            subarr = aux.getAllInternals();
            for (int i = 0; i < subarr.size(); i++) {
                intern.add(subarr.get(i));
            }
            if(aux.isIntern()){
                intern.add(aux.getValue());
            }
            aux = aux.getNextSibling();
        }
        return intern;
    }

    public ArrayList<T> getAllSiblings(){
        if(this.getFather() == null){
            return null;
        }
        ArrayList<T> siblings = new ArrayList<T>();
        Node<T> aux = this.getFather().getFirstChild();
        while(aux != null){
            siblings.add(aux.getValue());
            aux = aux.getNextSibling();
        }
        return siblings;
    }

    public ArrayList<T> getAllAncestors(){
        if(this.father == null){
            return new ArrayList<T>();    
        }
        ArrayList<T> ancestors = new ArrayList<T>();
        Node<T> aux = this.father;
        while(aux != null){
            ancestors.add(aux.getValue());
            aux = aux.getFather();
        }
        return ancestors;
    }

    public ArrayList<T> getAllDownwards(){
        if(this.isLeaf()){
            return new ArrayList<T>();
        }
        ArrayList<T> downwards = new ArrayList<T>();
        ArrayList<T> subarr;
        Node<T> aux = this.getFirstChild();
        while(aux != null){
            subarr = aux.getAllDownwards();
            for (int i = 0; i < subarr.size(); i++) {
                downwards.add(subarr.get(i));
            }
            downwards.add(aux.getValue());
            aux = aux.getNextSibling();
        }
        return downwards;
    }

    public int getDepth(){
        if(this.father == null){
            return 0;
        }
        int depth = 0;
        Node<T> aux = this.father;
        while(aux != null){
            depth++;
            aux = aux.getFather();
        }

        return depth;
    }

    public int getHeight(){
        if(this.isLeaf()){
            return 0;
        }
        int height = 0;
        Node<T> aux = this.getFirstChild();
        int auxHeight = 0;
        
        while(aux != null){
            auxHeight = aux.getHeight();
            if(auxHeight > height){
                height = auxHeight;
            }
            aux = aux.getNextSibling();
        }
        return height+1;
    }

    public ArrayList<T> getAllChildren(){
        if(this.isLeaf()){
            return new ArrayList<T>();
        }
        ArrayList<T> children = new ArrayList<T>();
        Node<T> aux = this.getFirstChild();
        while(aux != null){
            children.add(aux.getValue());
            aux = aux.getNextSibling();
        }
        return children;
    }
}
