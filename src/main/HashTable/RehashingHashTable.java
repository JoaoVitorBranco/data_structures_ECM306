package main.HashTable;

public class RehashingHashTable {
    /*
    Class created by João Branco and Vitor Soller
    Repository can be viewed at https://github.com/JoaoVitorBranco/data_structures_ECM306
     
    public RehashingHashTable(int size) 
    public void insert(int key, int value)
    public Integer rehashing(int key)
    public int get(int key)
    public void printHash()
    public int getLen()
    private int hash(int key)
    public int hashvalue(int key)
    */
    
    private Integer[] table;

    public RehashingHashTable(int size) {
        this.table = new Integer[size];
    }

    public void insert(int key, int value){
        int idx = hash(key);

        Integer aux = this.table[idx];
        if(aux == null){
            this.table[idx] = value;
        }
        else{
            Integer newIdx = rehashing(key);
            if(newIdx != null){
                this.table[newIdx] = value;
            }
        }
    }

    public Integer rehashing(int key){
        int idx = hash(key);
        if(this.table[idx] == null){
            return idx;
        }
        else{
            int idxAux = idx + 1;
            while(idxAux != idx){
                if(idxAux == this.table.length){
                    idxAux = 0;
                }
                if(this.table[idxAux] == null){
                    return idxAux;
                }
                idxAux++;
            }
            return null;
        }
    }

    public int get(int key){
        int idx = hash(key);
        return this.table[idx];
    }

    public void printHash(){
        if(this.table.length == 0){
            System.out.println("[]");
            return ;
        }
        else{
            System.out.print("[");
            System.out.print(String.valueOf(this.table[0]));
            for (int i = 1; i < table.length; i++) {
                System.out.print(", ");
                System.out.print(String.valueOf(this.table[i]));
            }
            System.out.println("]");
        }
    }
  
    public int getLen(){
        return this.table.length;
    }
    
    private int hash(int key){
        return key % this.table.length;
    }

    public int hashvalue(int key){
        return hash(key);
    }


}
