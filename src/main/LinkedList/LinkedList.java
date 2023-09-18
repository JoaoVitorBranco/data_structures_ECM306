package main.LinkedList;
import java.util.ArrayList;


public class LinkedList<T> {
    /*
     * Class created by João Branco and Vitor Soller
     * Repository can be viewed at https://github.com/JoaoVitorBranco/data_structures_ECM306
     */
    private Node<T> head;
    private int len;

    /*
     * void addLast(T tail_val)
     * pop(int index)
     * get
     * insert
     * getLen
     * get(int index)
     * insert(int index, T insertion_val)
     * getLen()
     * printList()
     * update(int idx, T update_val)
     * addFirst(T head_val)
     * T popFirst()
     * T popLast()
     */

    public LinkedList(){
        this.head = null;
        this.len = 0;        
    }
    
    public LinkedList(T val){
        Node<T> head = new Node<T>(val);
        this.head = head;
        this.len = 1;
    }

    public LinkedList(ArrayList<T> list){
        this.len = list.size();
        if(this.len == 0){
            this.head = null;
        }else{
            this.head = new Node<T>(list.get(0));
            Node<T> aux = this.head;
            for (int i = 0; i < this.len-1; i++) {
                aux.setNext(new Node<T>(list.get(i+1)));
                aux = aux.getNext();
            }
        }
    }

    public void addLast(T tail_val){
        Node<T> tail = new Node<T>(tail_val);
        if(head == null){
            this.head = tail;
            this.len = 1;    
        }
        else{
            int length = 2;
            Node<T> aux = this.head;
            Node<T> next = aux.getNext();
            while(next != null){
                aux = next;
                next = aux.getNext();
                length += 1;
            }
            aux.setNext(tail);
            this.len = length;
        }
    }

    public T pop(int index){
        if (index < 0 || index > this.len-1){
            System.out.println("Value " +index+ " need to be greater than 0 and lower than "+(this.len-1));
            return null;
        }
        Node<T> aux = this.head;
        
        if(index == 0){
            this.head = this.head.getNext();
            this.len -= 1;
            return aux.getValue();
        }
        Node<T> next = this.head;
        
        for (int i = 0; i < index; i++) {
            aux = next;
            next = aux.getNext();
        }
        aux.setNext(next.getNext());
        this.len -= 1;
        return next.getValue();
    }

    public T get(int index){
        if (index < 0 || index > this.len-1){
            System.out.println("Value " +index+ " need to be greater than 0 and lower than "+(this.len-1));
            return null;
        }
        Node<T> next = this.head;
        Node<T> aux;
        for (int i = 0; i < index; i++) {
            aux = next;
            next = aux.getNext();
        }
        return next.getValue();
    }
    
    public void insert(int index, T insertion_val){
        Node<T> insertion = new Node<T>(insertion_val); 
        if (index < 0 || index > this.len){
            System.out.println("Value " +index+ " need to be greater than 0 and lower than "+(this.len-1));
            return ;
        }
        Node<T> aux = this.head;
        
        if(index == 0){
            insertion.setNext(this.head);
            this.head = insertion;
            this.len += 1;
            return ;
        }
        Node<T> next = this.head;
        
        for (int i = 0; i < index; i++) {
            aux = next;
            next = aux.getNext();
        }
        if(next != null) insertion.setNext(next);
        aux.setNext(insertion);
        this.len += 1;
        return ;
        
        

    }

    public int getLen(){
        return this.len;
    }

    public void printList(){
        Node<T> aux = this.head;
        System.out.print("[");
        if(aux != null){
            System.out.print(""+aux.getValue());
            aux = aux.getNext();
            while(aux != null){
                System.out.print(", "+aux.getValue());
                aux = aux.getNext();               
            }
        }
        System.out.print("]");
    } 

    public void update(int idx, T update_val){
        if(idx < 0 || idx > this.len-1){
            System.out.println("Value " +idx+ " need to be greater than 0 and lower than "+(this.len-1));
            return ;
        }
        Node<T> aux = this.head;
        for (int i = 0; i < idx; i++) {
            aux = aux.getNext();
        }
        aux.setValue(update_val);
    }

    public void addFirst(T head_val){
        if(this.head == null){
            this.head = new Node<T>(head_val);
        }
        else{
            Node<T> aux = this.head;
            this.head = new Node<T>(head_val);
            this.head.setNext(aux);
        }
        this.len++;
    }

    public T popFirst(){
        if(this.len == 0){
            System.out.println("List is empty");
            return null;
        }
        Node<T> aux = this.head;
        this.head = this.head.getNext();
        this.len--;
        return aux.getValue();
    }

    public T popLast(){
        if(this.len == 0){
            System.out.println("List is empty");
            return null;
        }
        Node<T> aux = this.head;
        Node<T> next = aux.getNext();
        if(next == null){
            this.head = null;
            this.len--;
            return aux.getValue();
        }
        while(next.getNext() != null){
            aux = next;
            next = aux.getNext();
        }
        aux.setNext(null);
        this.len--;
        return next.getValue();
    }
}