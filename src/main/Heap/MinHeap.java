package main.Heap;
import java.util.ArrayList;

public class MinHeap{
    /*
    Class created by João Branco and Vitor Soller
    Repository can be viewed at https://github.com/JoaoVitorBranco/data_structures_ECM306
    
    Métodos
    private ArrayList<Integer> arr
    public Heap(int[] arr)
    private void heapifySubtree(int idxParent)
    private void heapify()
    public boolean isHeap()
    public static boolean isHeap(int[] arr)
    public int getLen()
    public Integer get(int idx)
    public void append(int val)
    public int getHeight()
    public void print()
    public int leftChildIdx(int idx)
    public int rightChildIdx(int idx)
    public int parentIdx(int idx)
     */
    private ArrayList<Integer> arr;

    public MinHeap(int[] arr){
        this.arr = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            this.arr.add(arr[i]);
        }
        if(!this.isHeap()){
            this.heapify();
        }
    }

    private void heapifySubtree(int idxParent){
        int idxLeft = 2 * idxParent + 1;
        int idxRight = 2 * idxParent + 2;
        int idxMin = idxParent;

        if(idxLeft < this.getLen() && this.get(idxLeft+1) < this.get(idxMin+1)){
            idxMin = idxLeft;
        }
        if(idxRight < this.getLen() && this.get(idxRight+1) < this.get(idxMin+1)){
            idxMin = idxRight;
        }

        if(idxMin != idxParent){
            int aux = this.arr.get(idxParent);
            this.arr.set(idxParent, this.arr.get(idxMin)); 
            this.arr.set(idxMin, aux);
            this.heapifySubtree(idxMin);
        }
    } 

    private void heapify(){
        for (int i = (this.getLen() - 1) / 2; i >= 0; i--) {
            this.heapifySubtree(i);
        }
    }

    public boolean isHeap(){
        for (int i = 2; i < arr.size(); i++) {
            if(this.get(i) < this.get(i/2)){
                return false;
            }                
        }
        return true;
    }

    public static boolean isHeap(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[(i-1)/2]){
                return false;
            }                
        }
        return true;
    }

    public int getLen(){
        return arr.size();
    }

    public Integer get(int idx){
        if(idx <= 0 || idx > arr.size()){
            return null;
        }
        return arr.get(idx-1);
    }

    public void append(int val){
        this.arr.add(val);
        if(this.get(this.getLen() / 2) < val){
            this.heapify();
        }
    }

    public int getHeight(){
        return (int) Math.ceil(Math.log(this.getLen()) / Math.log(2));
    }

    public void print(){
        System.out.print("[");
        if(this.getLen() == 0){
            System.out.println("]");
        }
        else{
            int i;
            for(i = 0; i < this.getLen() - 1; i++){
                System.out.print(this.get(i+1) + ", ");
            }
            System.out.println(this.get(i+1) + "]");
        }
    }

    public int leftChildIdx(int idx){
        return 2 * idx;
    }

    public int rightChildIdx(int idx){
        return 2 * idx + 1;
    }

    public int parentIdx(int idx){
        return idx / 2;
    }

    public int nodeHeight(int idx){
        return (int) Math.floor(Math.log(arr.size()/idx) / Math.log(2));
    }
}