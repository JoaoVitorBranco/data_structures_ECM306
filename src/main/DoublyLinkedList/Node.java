package main.DoublyLinkedList;
public class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private T value;
    
    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
        this.previous = null;
    }

    public Node(T value, Node<T> next, Node<T> previous) {
        this.value = value;
        this.next = next;
        this.previous = null;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public Node<T> getPrevious(){
        return this.previous;
    }

    public void setPrevious(Node<T> previous){
        this.previous = previous;
    }
}
