package tests.TestHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.HashTable.ChainingHashTable;

public class TestChainingHashTable {
    public static void main(String[] args) {
        // 2
        ChainingHashTable hash2 = new ChainingHashTable(10);
        int[] domain2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        // 3
        ChainingHashTable hash3 = new ChainingHashTable(10);
        int[] domain3 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Testando hash2
        System.out.println("Para o hash2, foram inseridos valores aleatórios de 1 a 19 (10 vezes) com o número da chave sendo o mesmo para o valor inserido:");
        for (int i = 0; i < domain2.length; i++) {
            hash2.insert(domain2[i], domain2[i]);
        }
        hash2.printHash();

        // Testando hash3
        System.out.println("\nPara o hash3, foram inseridos valores aleatórios de 0 a 10 (10 vezes) com o número da chave sendo o mesmo para o valor inserido:");
        for (int i = 0; i < 10; i++) {
            hash3.insert(domain3[i], domain3[i]);
        }
        hash3.printHash();

        // 7
        ChainingHashTable hash7 = new ChainingHashTable(1000);
        int[] domain7 = new int[100000];
        for (int i = 0; i < domain7.length; i++) {
            domain7[i] = i;
        }
        
        // Testando hash7
        System.out.println("\nPara o hash7, foram inseridos valores aleatórios de 0 a 100000 (1000 vezes) com o número da chave sendo o mesmo para o valor inserido:");
        for (int i = 0; i < 100000; i++) {
            hash7.insert(domain7[i], domain7[i]);
        }
        // hash7.printHash();

    }

    @Test
    public void testIsIn(){
        ChainingHashTable hash = new ChainingHashTable(10);
        int[] domain = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        for (int i = 0; i < domain.length; i++) {
            hash.insert(domain[i], domain[i]);
        }
        hash.printHash();

        for (int i = 0; i < domain.length; i++) {
            assertTrue(hash.isIn(domain[i]) != -1);
        }

        assertEquals(hash.isIn(20), -1);
        assertEquals(hash.isIn(0), -1);
        assertEquals(hash.isIn(21), -1);

    }

    @Test
    public void testPop(){
        ChainingHashTable hash = new ChainingHashTable(10);
        int[] domain = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        for (int i = 0; i < domain.length; i++) {
            hash.insert(domain[i], domain[i]);
        }
        hash.printHash();

        for (int i = 0; i < domain.length; i++) {
            assertEquals(hash.pop(domain[i]), hash.getHash(domain[i]));
        } 
        assertEquals(hash.isIn(2), -1);
    }
}
