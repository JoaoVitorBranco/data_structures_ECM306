package tests.TestHashMap;

import main.HashTable.RehashingHashTable;

public class TestRehashingHashTable {
    public static void main(String[] args) {
        // 2
        RehashingHashTable hash = new RehashingHashTable(10);
        int[] domain = new int[]{23, 45, 77, 11, 33, 49, 10, 4, 89, 14};
        for (int i = 0; i < domain.length; i++) {
            hash.insert(domain[i], domain[i]);
        }
        
        // 4
        System.out.println("Para a chave 23: " + String.valueOf(hash.hashvalue(23)));
        System.out.println("Para a chave 10: " + String.valueOf(hash.hashvalue(10)));
        System.out.println("Para a chave 4: " + String.valueOf(hash.hashvalue(4)));
        
        // 5
        RehashingHashTable hash2 = new RehashingHashTable(10);
        int[] domain2 = new int[]{23, 45, 77, 11};
        System.out.println("Para a chave 22 no hash1: " + String.valueOf(hash.rehashing(22)));
        System.out.println("Para a chave 22 no hash2: " + String.valueOf(hash2.rehashing(22)));
        System.out.println("Para a chave 23 no hash2: " + String.valueOf(hash2.rehashing(23)));
        
        // 6
        System.out.println("Inserindo 22 no hash1, 22 e 42 no hash2: ");
        hash.insert(22, 22);
        hash2.insert(22, 22);
        hash2.insert(42, 42);
        System.out.println("Hash1: ");
        hash.printHash();
        System.out.println("Hash2: ");
        hash2.printHash();

    }
}
