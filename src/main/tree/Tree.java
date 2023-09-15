package main.tree;

import java.util.ArrayList;

public class Tree<T> {

    /*
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
     */
    private Node<T> root;
    private int size;

    public Tree(){
        this.root = null;
        this.size = 0;
    }

    public Tree(Node<T> root){
        this.root = root;
        this.size = 1;
    }

    public void addChild(Node<T> father, T value){
        Node<T> aux = father.getFirstChild();
        if (aux == null){
            father.setFirstChild(new Node<T>(father, value));
        }    
        else{

            while(aux.getNextSibling() != null){
                aux = aux.getNextSibling();
            }
            aux.setNextSibling(new Node<T>(father, value));
        }
        size++;
        return ;
    }

    public void addChild(T value){
        if(this.root == null){
            this.root = new Node<T>(value);
        }
        else{
            System.out.println("Árvore deve estar vazia para preencher um root");
        }
    }

    public void printChildren(Node<T> node){
        node.printChildren();
    };

    public Node<T> getFather(Node<T> node){
        return node.getFather();
    }

    public void printFather(Node<T> node){
        Node<T> father = node.getFather();
        if (father == null){
            System.out.println("null");
            return ;
        }
        System.out.println(father.getValue());
    }

    public boolean nodeIsIntern(Node<T> node){
        return node.isIntern();
    }

    public void printLeafChildren(Node<T> node){
        node.printLeafChildren();
    }

    public void printPreorder(Node<T> startNode){
        System.out.print("[" + String.valueOf(startNode.getValue()));
        Node<T> aux = startNode;
        boolean already_printed = false;
        do {
            if(aux.getFirstChild() != null && ! already_printed){
                aux = aux.getFirstChild();
                System.out.print(", " + String.valueOf(aux.getValue()));
            }
            else if(aux.getNextSibling() != null){
                aux = aux.getNextSibling();
                System.out.print(", " + String.valueOf(aux.getValue()));
                already_printed = false;
            }
            else{
                aux = aux.getFather();
                already_printed = true;
            }
        } while(aux.getFather() != null || aux == null);
        System.out.println("]");
    }

    public void printPosorder(Node<T> startNode){
       System.out.print("[" + String.valueOf(startNode.getValue()));
        Node<T> aux = startNode;
        if(aux.getFather() == null){
            System.out.println("]");
            return ;
        }
        boolean already_printed = aux.getFirstChild() != null;
        do {
            if(aux.getFirstChild() != null && ! already_printed){
                aux = aux.getFirstChild();
                if(aux.getFirstChild() == null){
                    System.out.print(", " + String.valueOf(aux.getValue()));
                }
            }
            else if(aux.getNextSibling() != null){
                aux = aux.getNextSibling();
                if(aux.getFirstChild() == null){
                    System.out.print(", " + String.valueOf(aux.getValue()));
                }
                already_printed = false;
            }
            else{
                aux = aux.getFather();
                System.out.print(", " + String.valueOf(aux.getValue()));
                already_printed = true;
            }
        } while(aux.getFather() != null || aux == null);
        System.out.println("]");
    }

    public void doubleChildren(Node<Integer> node){
        Node<Integer> firstChild = node.getFirstChild();
        while(firstChild != null){
            firstChild.setValue(firstChild.getValue()*2);
            firstChild = firstChild.getNextSibling();
        }
    }

    public void doubleFather(Node<Integer> node){
        if(node.getFather() != null){
            node.getFather().setValue(node.getFather().getValue() * 2);
        }
    }

    public ArrayList<T> getAllSiblings(Node<T> node){
        return node.getAllSiblings();
    } 

    public ArrayList<T> getAllInternals(Node<T> node){
        return node.getAllInternals();
    }

    public ArrayList<T> getAllAncestors(Node<T> node){
        return node.getAllAncestors();
    }

    public ArrayList<T> getAllDownwards(Node<T> node){
        return node.getAllDownwards();
    }

    public int getDepth(Node<T> node){
        return node.getDepth();
    }

    public int getHeight(Node<T> node){
        return node.getHeight();
    }

    public int getTreeHeight(){
        if(this.root == null){
            return 0;
        }
        return this.root.getHeight();
    }

    public int getSize(){
        return this.size;
    }

    public T getRoot(){
        if(this.root == null){
            return null;
        }
        return this.root.getValue();
    }

    public ArrayList<T> getAllChildren(Node<T> node){
        return node.getAllChildren();
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public ArrayList<T> getAllNodes(){
        if(this.isEmpty()){
            return new ArrayList<T>();
        }
        ArrayList<T> allNodes = this.root.getAllDownwards();
        allNodes.add(this.root.getValue());
        return allNodes;
    }

    public void replace(Node<T> node, T val){
        node.setValue(val);
    }
} 

