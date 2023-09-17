package main.FIFO;

import main.CircularDoublyLinkedList.CircularDoublyLinkedList;
import main.DoublyLinkedList.DoublyLinkedList;
import main.LinkedList.LinkedList;

public class Fifo<T> {
    private CircularDoublyLinkedList<T> circularStack;
    private DoublyLinkedList<T> doublyStack;
    private LinkedList<T> linkedStack;
    private int config;

    /*
     * void push(T value)
     * T pop()
     * void print()
     * int getConfig()
     * int getSize()
     * T getHead()
     * T getTail()
     */

    public Fifo(int config){
        this.config = config;
        switch (config) {
            case 0:
                this.circularStack = new CircularDoublyLinkedList<T>();
                break;
            case 1:
                this.doublyStack = new DoublyLinkedList<T>();
                break;
            case 2:
                this.linkedStack = new LinkedList<T>();
                break;
            default:
                System.out.println("Invalid config. Default config will be selected: LinkedList");
                this.linkedStack = new LinkedList<T>();
                this.config = 2;
                break;
        }
    }

    public void push(T value){
        switch (this.config) {
            case 0:
                this.circularStack.insertFirst(value);
                break;
            case 1:
                this.doublyStack.insertFirst(value);
                break;
            case 2:
                this.linkedStack.addFirst(value);
                break;
            default:
                break;
        }
    }

    public T pop(){
        T value = null;
        switch (this.config) {
            case 0:
                value = this.circularStack.popLast();
                break;
            case 1:
                value = this.doublyStack.popLast();
                break;
            case 2:
                value = this.linkedStack.popLast();
                break;
            default:
                break;
        }
        return value;
    }

    public void print(){
        switch (this.config) {
            case 0:
                this.circularStack.printList();
                break;
            case 1:
                this.doublyStack.printList();
                break;
            case 2:
                this.linkedStack.printList();
                break;
            default:
                break;
        }
    }

    public int getConfig(){
        return this.config;
    }

    public int getSize(){
        switch (this.config) {
            case 0:
                return this.circularStack.getSize();
            case 1:
                return this.doublyStack.getSize();
            case 2:
                return this.linkedStack.getLen();
            default:
                return -1;
        }
    }

    public T getHead(){
        T value = null;
        switch (this.config) {
            case 0:
                value = this.circularStack.get(0);
                break;
            case 1:
                value = this.doublyStack.get(0);
                break;
            case 2:
                value = this.linkedStack.get(0);
                break;
            default:
                break;
        }
        return value;
    }

    public T getTail(){
        T value = null;
        switch (this.config) {
            case 0:
                value = this.circularStack.get(this.circularStack.getSize() - 1);
                break;
            case 1:
                value = this.doublyStack.get(this.doublyStack.getSize() - 1);
                break;
            case 2:
                value = this.linkedStack.get(this.linkedStack.getLen() - 1);
                break;
            default:
                break;
        }
        return value;
    }
}
