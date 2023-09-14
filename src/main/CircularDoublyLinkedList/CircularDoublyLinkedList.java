package main.CircularDoublyLinkedList;

import java.util.ArrayList;

public class CircularDoublyLinkedList<T> {
    private Node<T> ward;
    private int size;
    
    public CircularDoublyLinkedList(){
        this.ward = new Node<T>();
        this.size = 0;
    }

    public CircularDoublyLinkedList(ArrayList<T> list){
        this.size = list.size();
        this.ward = new Node<T>();
        if(this.size == 1){
            this.ward.setNext(new Node<T>(list.get(0)));
            this.ward.setPrevious(new Node<T>(list.get(0)));
            this.ward.getNext().setPrevious(ward);
            this.ward.getNext().setNext(ward);
        }
        else if(this.size > 0){
            Node<T> aux_previous = new Node<T>(list.get(0));
            Node<T> aux_next = new Node<T>(list.get(1));
            this.ward.setNext(aux_previous);
            aux_previous.setPrevious(this.ward);
            for (int i = 1; i < this.size - 1; i++) {
                aux_previous.setNext(aux_next);
                aux_next.setPrevious(aux_previous);
                aux_previous = aux_next;
                aux_next = new Node<T>(list.get(i+1));
            }
            aux_previous.setNext(aux_next);
            aux_next.setPrevious(aux_previous);
            this.ward.setPrevious(aux_next);
            aux_next.setNext(ward);
        }
    }

    public int getSize(){
        return this.size;
    }

    public void printList(){
        System.out.print("[");
        if(this.size == 0){
            System.out.println("]");
            return ;
        }
        Node<T> aux = this.ward.getNext();
        for (int i = 0; i < this.getSize()-1; i++) {
            System.out.print(String.valueOf(aux.getValue())+", ");
            aux = aux.getNext();
        }
        System.out.println(String.valueOf(aux.getValue())+"]");
        
        
    }
    
    public T get(int index){
        if(index < 0 || index >= this.getSize()){
            System.out.println("Index deve estar entre 0 e " + String.valueOf(this.size - 1));
            return null;
        }
        Node<T> aux = this.ward.getNext();
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        return aux.getValue();
        
    }

    public void insert(int index, T new_node_val){
        Node<T> new_node = new Node<T>(new_node_val);
        if(this.size == 0 && (index == 0 || index == this.size - 1)){
            this.ward.setNext(new_node);
            this.ward.setPrevious(new_node);
            new_node.setNext(this.ward);
            new_node.setPrevious(this.ward);
        }
        else if(index < 0 || index > this.getSize()){
            System.out.println("Index deve estar entre 0 e " + String.valueOf(this.size - 1));
            return ;
        }
        else if(index == 0){
            this.ward.getNext().setPrevious(new_node);
            new_node.setNext(this.ward.getNext());
            this.ward.setNext(new_node);
            new_node.setPrevious(this.ward);
        }else if(index == this.size){
            this.ward.getPrevious().setNext(new_node);
            new_node.setPrevious(new_node);
            this.ward.setPrevious(new_node);
            new_node.setNext(this.ward);
        }else{
            Node<T> aux_previous = this.ward.getNext();
            Node<T> aux_next = aux_previous.getNext();
            for(int i = 0; i < index - 1; i++){
                aux_previous = aux_next;
                aux_next = aux_previous.getNext();
            }
            aux_previous.setNext(new_node);
            aux_next.setPrevious(new_node);
            new_node.setPrevious(aux_previous);
            new_node.setNext(aux_next);
        }
        this.size++;
    }

    public T pop(int index){
        if(this.getSize() == 0){
            System.out.println("Não se pode utilizar este método em uma lista vazia");
            return null;
        }
        else if(index < 0 || index >= this.getSize()){
            System.out.println("Index deve estar entre 0 e " + String.valueOf(this.size - 1));
            return null;
        }
        T value = null;
        if(this.getSize() == 1 && (index == 0)){
            value = this.ward.getNext().getValue();
            this.ward.setNext(null);
            this.ward.setPrevious(null);
        }else if(index == 0){
            value = this.ward.getNext().getValue();
            this.ward.getNext().getNext().setPrevious(this.ward);
            this.ward.setNext(this.ward.getNext().getNext());
        }else if(index == this.size - 1){
            value = this.ward.getPrevious().getValue();
            this.ward.getPrevious().getPrevious().setNext(this.ward);
            this.ward.setPrevious(this.ward.getPrevious().getPrevious());
        }else{
            Node<T> aux_previous = this.ward.getNext();
            Node<T> aux_to_pop = aux_previous.getNext();
            for(int i = 0; i < index - 2; i++){
                aux_previous = aux_to_pop;
                aux_to_pop = aux_previous.getNext();
            }
            value = aux_to_pop.getValue();
            aux_previous.setNext(aux_to_pop.getNext());
            aux_to_pop.getNext().setPrevious(aux_previous);
        }
        this.size--;
        return value;
    }

    public void printFirst(){
        System.out.println(this.ward.getNext().getValue());
    }
    
    public void printLast(){
        System.out.println(this.ward.getPrevious().getValue());
    }

    public T popFirst(){
        return this.pop(0);
    }

    public T popLast(){
        return this.pop(this.size - 1);
    }
}

