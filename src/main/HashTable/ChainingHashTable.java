package main.HashTable;
import main.LinkedList.LinkedList;

public class ChainingHashTable {
    /*
    Class created by João Branco and Vitor Soller
    Repository can be viewed at https://github.com/JoaoVitorBranco/data_structures_ECM306
     
    Explanation:
    HashTable stores a value, that represents its key. The key is calculated by a hash function defined in this class.

    Methods:
    public ChainingHashTable(int size) 
    public void insert(int key, int value)
    public int get(int key)
    public void printHash()
    public int getLen()
    private int hash(int key)
    public boolean isAssociative()
    public int isIn(int value)
    public int pop(int value)
    */
    private LinkedList<Integer>[] table;

    public ChainingHashTable(int size) {
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<Integer>();
        }
    }

    public void insert(int key, int value){
        int idx = hash(key);
        this.table[idx].addLast(value);
    }

    public int get(int key){
        int idx = hash(key);
        return this.table[idx].get(0);
    }

    public void printHash(){
        if(this.table.length == 0){
            System.out.println("[]");
            return ;
        }
        else{
            System.out.print("[\n");
            for (int i = 0; i < this.table.length-1; i++) {
                System.out.print("\t");
                this.table[i].printList();
                System.out.print(",\n");

            }
            System.out.print("\t");
            this.table[this.table.length-1].printList();
            System.out.println("\n]");
        }
    }
  
    public int getLen(){
        int len = 0;
        for (LinkedList<Integer> linkedList : table) {
            len += linkedList.getLen();
        }
        return len;
    }
    
    private int hash(int key){
        return key % this.table.length;
    }

    public int getHash(int key){
        return hash(key);
    }

    public boolean isAssociative(){
        for (int i = 0; i < table.length; i++) {
            if(i != hash(i)){
                return false;
            }
        }
        return true;
    }

    public int isIn(int value){
        int idx = hash(value);
        if(table[idx].isIn(value)){
            return idx;
        }
        return -1;
    }

    public int pop(int value){
        int idx = isIn(value);
        if(idx == -1){
            return -1;
        }
        int linkedListIdx = this.table[idx].find(value);
        if(linkedListIdx == -1){
            return -1;
        }
        table[idx].pop(linkedListIdx); 
        return idx;
    }
}