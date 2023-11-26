package main.PriorityQueue;

import java.util.ArrayList;

public class HeapPacient{
    private ArrayList<Pacient> arr;

    public HeapPacient(Pacient[] arr){
        this.arr = new ArrayList<Pacient>();
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
        int idxMax = idxParent;
        if(idxLeft < this.getLen() ){
            if(biggerPriority(this.get(idxLeft+1), this.get(idxMax+1))){
                idxMax = idxLeft;
            }
        }
        if(idxRight < this.getLen() ){
            if(idxRight < this.getLen() && biggerPriority(this.get(idxRight+1), this.get(idxMax+1))){
                idxMax = idxRight;
           }
        }
        if(idxMax != idxParent){
            Pacient aux = this.arr.get(idxParent);
            this.arr.set(idxParent, this.arr.get(idxMax));
            this.arr.set(idxMax, aux);
            this.heapifySubtree(idxMax);
        }
    } 

    private void heapify(){
        for (int i = (this.getLen() - 1) / 2; i >= 0; i--) {
            this.heapifySubtree(i);
        }
    }

    public boolean isHeap(){
        for (int i = 2; i < arr.size(); i++) {
            if(biggerPriority(this.get(i), this.get(i/2))){
                return false;
            }                
        }
        return true;
    }

    public static boolean isHeap(Pacient[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(biggerPriority(arr[i], arr[(i-1)/2])){
                return false;
            }                
        }
        return true;
    }

    public int getLen(){
        return arr.size();
    }

    public Pacient get(int idx){
        if(idx <= 0 || idx > arr.size()){
            return null;
        }
        return arr.get(idx-1);
    }

    public void append(Pacient val){
        this.arr.add(val);
        if(this.getLen() == 1){
            return;
        }else if(!biggerPriority(this.get(this.getLen() / 2), val)){
            this.heapify();
        }
    }

    public int getHeight(){
        return (int) Math.ceil(Math.log(this.getLen()) / Math.log(2));
    }

    public String toString(){
        String s = "[";
        if(this.getLen() == 0){
            return s + "]";
        }
        else{
            int i;
            for(i = 0; i < this.getLen() - 1; i++){
                s += this.get(i+1).toString() + ", ";
            }
            return s + this.get(i+1).toString() + "]";
        }
    }

    public static boolean biggerPriority(Pacient p1, Pacient p2){
        if(p2 == null && p1 == null){
            return false;
        } else if(p2 == null){
            return true;
        } else if(p1 == null){
            return false;
        }
        if(p1.priority < p2.priority){
            return true;
        } else if(p1.priority > p2.priority){
            return false;
        } else{
            if(p1.id < p2.id){
                return true;
            } else{
                return false;
            }
        }
    }

    public Pacient pop(){
        Pacient p = this.get(1);
        if(biggerPriority(this.get(3), this.get(2))){
            Pacient aux = this.arr.get(2);
            this.arr.set(2, this.arr.get(1));
            this.arr.set(1, aux);
        }
        this.arr.remove(0);
        if(!isHeap()){
            this.heapify();
        }
        return p;
    }

}