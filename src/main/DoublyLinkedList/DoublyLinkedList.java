package main.DoublyLinkedList;
import java.util.ArrayList;

public class DoublyLinkedList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoublyLinkedList(T head_val){
        Node<T> head = new Node<T>(head_val);
        this.head = head;
        this.tail = null;
        this.size = 1;
    }
    
    public DoublyLinkedList(T head_val, T tail_val){
        Node<T> head = new Node<T>(head_val);
        Node<T> tail = new Node<T>(tail_val);
        this.head = head;
        this.tail = tail;
        this.size = 2;
    }

    public DoublyLinkedList(ArrayList<T> list){
        this.size = list.size();
        if(this.size == 0){
            this.head = null;
            this.tail = null;
        }
        else if(this.size == 1){
            Node<T> aux = new Node<T>(list.get(0));
            aux.setNext(null);
            aux.setPrevious(null);
            this.head = aux;
            this.tail = aux;
        }
        else{
            this.head = new Node<T>(list.get(0));
            this.head.setPrevious(null);
            Node<T> aux = this.head;

            this.tail = new Node<T>(list.get(this.size - 1));
            for (int i = 1; i < this.size - 1; i++) {
                aux.setNext(new Node<T>(list.get(i)));
                aux.getNext().setPrevious(aux);
                aux = aux.getNext();
            }
            aux.setNext(this.tail);
            this.tail.setPrevious(aux);
            this.tail.setNext(null);
        }
    }

    public int getSize(){
        return this.size;
    }

    public void printList(){
        System.out.print("[");
        if(this.getSize() == 0){
            System.out.println("]");
            return ;
        }
        Node<T> aux = this.head;
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
        Node<T> aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        return aux.getValue();
        
    }

    public void insert(int index, T new_node_val){
        Node<T> new_node = new Node<T>(new_node_val);
        if(this.size == 0 && (index == 0 || index == this.size - 1)){
            this.head = new_node;
            this.head.setNext(null);
            this.tail = new_node;
            this.tail.setPrevious(null);
        }
        else if(index < 0 || index > this.getSize()){
            System.out.println("Index deve estar entre 0 e " + String.valueOf(this.size - 1));
            return ;
        }
        else if(index == 0){
            this.head.setPrevious(new_node);
            new_node.setPrevious(null);
            new_node.setNext(this.head);
            this.head = new_node;
            
        }else if(index == this.size){
            this.tail.setNext(new_node);
            new_node.setPrevious(this.tail);
            new_node.setNext(null);
            this.tail = new_node;
        } else{
            Node<T> aux_previous = this.head;
            Node<T> aux_next = aux_previous.getNext();
            for(int i = 0; i < index - 2; i++){
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
            value = this.head.getValue();
            this.head = null;
            this.tail = null;
        }else if(index == 0){
            value = this.head.getValue();
            this.head.getNext().setPrevious(null);
            this.head = this.head.getNext();
            
        }else if(index == this.size - 1){
            value = this.tail.getValue();
            this.tail.getPrevious().setNext(null);
            this.tail = this.tail.getPrevious();
        } else{
            Node<T> aux_previous = this.head;
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

    public T popFirst(){
        return this.pop(0);
    }

    public T popLast(){
        return this.pop(this.getSize() - 1);
    }

    public void printFirst(){
        if(this.head == null){
            System.out.println("Lista vazia");
        }
        else{
            System.out.println(this.head.getValue());
        }
    }

    public void printLast(){
        if(this.tail == null){
            System.out.println("Lista vazia");
        }
        else{
            System.out.println(this.tail.getValue());
        }
    }

    public void insertLast(T new_node_val){
        this.insert(this.getSize(), new_node_val);
    }

    public void insertFirst(T new_node_val){
        this.insert(0, new_node_val);
    }

    
}