package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import main.CircularDoublyLinkedList.CircularDoublyLinkedList;

public class TestCircularDoublyLinkedList {
    public static void main(String[] args) {
        testDefaultFunctions();
    }

    public static void testDefaultFunctions(){
        System.out.println("====== Teste DoublyLinkedList - ArrayList in Construtor ======");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        
        CircularDoublyLinkedList<Integer> cdlk1 = new CircularDoublyLinkedList<Integer>(list);
        CircularDoublyLinkedList<Integer> cdlk2 = new CircularDoublyLinkedList<Integer>(new ArrayList<Integer>(Arrays.asList()));
        CircularDoublyLinkedList<Integer> cdlk3 = new CircularDoublyLinkedList<Integer>(new ArrayList<Integer>(Arrays.asList(0)));
        CircularDoublyLinkedList<Integer> cdlk4 = new CircularDoublyLinkedList<Integer>(new ArrayList<Integer>(Arrays.asList()));
        

        System.out.print("Para a lista: ");
        cdlk1.printList();
        System.out.println("Lista deve ter 4 elementos: " + String.valueOf(cdlk1.getSize() == 4));
        
        System.out.print("Para a lista: ");
        cdlk2.printList();
        System.out.println("Lista deve ter 0 elementos: " + String.valueOf(cdlk2.getSize() == 0));
        
        System.out.print("Para a lista: ");
        cdlk3.printList();
        System.out.println("Lista deve ter 1 elemento: " + String.valueOf(cdlk3.getSize() == 1));
        
        System.out.println("====== Teste DoublyLinkedList - método \"get\" ======"); 
        int v1 = cdlk1.get(0);
        int v2 = cdlk1.get(2);
        int v3 = cdlk1.get(3);
        System.out.println("Index 0 deve ter valor 1: "+ String.valueOf(v1 == 1));
        System.out.println("Index 2 deve ter valor 3: "+ String.valueOf(v2 == 3));
        System.out.println("Index 3 deve ter valor 4: "+ String.valueOf(v3 == 4));
        System.out.println("Deve ter erro: " + String.valueOf(null == cdlk1.get(-1)));
        System.out.println("Deve ter erro: " + String.valueOf(null == cdlk1.get(10)));

        System.out.println("====== Teste DoublyLinkedList - método \"insert\" ======");
        Integer insert_1 = 0;
        Integer insert_2 = 100;
        Integer insert_3 = 5;
        Integer insert_6 = 101;
        
        System.out.println("Para a lista: ");
        cdlk1.printList();
        
        cdlk1.insert(0, insert_1);
        System.out.println("Deve ter inserido valor 0 no index 0: ");
        cdlk1.printList();
        
        cdlk1.insert(3, insert_2);
        System.out.println("Deve ter inserido valor 100 no index 2: ");
        cdlk1.printList();
        
        cdlk1.insert(cdlk1.getSize() - 1, insert_3);
        System.out.println("Deve ter inserido valor 5 no último index: ");
        cdlk1.printList();
        System.out.println("Lista deve conter 7 elementos: " + String.valueOf(cdlk1.getSize() == 7));
        
        cdlk1.insert(1, insert_6);
        System.out.println("Deve ter inserido valor 101 no index 1: ");
        cdlk1.printList();
        System.out.println("Lista deve conter 8 elementos: " + String.valueOf(cdlk1.getSize() == 8));
        
        System.out.println("Para a lista: ");
        cdlk2.printList();
        Integer insert_4 = 0;
        cdlk2.insert(0, insert_4);
        System.out.println("Deve ter inserido valor 0 no primeiro index: ");
        cdlk2.printList();
        System.out.println("Lista deve conter 1 elemento: " + String.valueOf(cdlk2.getSize() == 1));
        
        System.out.println("Para a lista: ");
        cdlk4.printList();
        cdlk4.insert(cdlk4.getSize() - 1, insert_4);
        System.out.println("Deve ter inserido valor 0 no último index: ");
        cdlk4.printList();
        System.out.println("Lista deve conter 1 elemento: " + String.valueOf(cdlk4.getSize() == 1));
        
        
        System.out.println("====== Teste DoublyLinkedList - método \"pop\" ======");
        System.out.println("Para a lista: ");
        cdlk1.printList();
        
        Integer val1 = cdlk1.pop(0);
        System.out.println("Deve ter removido valor 0 do index 0: ");
        cdlk1.printList();
        System.out.println("E deve ter retornado valor 0: " + String.valueOf(val1 == 0));
        
        Integer val2 = cdlk1.pop(3);
        System.out.println("Deve ter removido valor 2 do index 2: ");
        cdlk1.printList();
        System.out.println("E deve ter retornado valor 2: " + String.valueOf(val2 == 2));
        
        Integer val3 = cdlk1.pop(cdlk1.getSize() - 1);
        System.out.println("Deve ter removido valor 4 do último index: ");
        cdlk1.printList();
        System.out.println("E deve ter retornado valor 4: " + String.valueOf(val3 == 4));
        
        Integer val6 = cdlk1.pop(1);
        System.out.println("Deve ter removido valor 1 do index 1: ");
        cdlk1.printList();
        System.out.println("E deve ter retornado valor 1: " + String.valueOf(val6 == 1));
        System.out.println("Lista deve conter 4 elementos: " + String.valueOf(cdlk1.getSize() == 4));
        
        System.out.println("Para a lista: ");
        cdlk2.printList();
        Integer val4 = cdlk2.pop(0);
        System.out.println("Deve ter removido valor 0 do primeiro index: ");
        cdlk2.printList();
        System.out.println("E deve ter retornado valor 0: " + String.valueOf(val4 == 0));
        System.out.println("Lista deve conter 0 elementos: " + String.valueOf(cdlk2.getSize() == 0));
        
        System.out.println("Para a lista: ");
        cdlk4.printList();
        Integer val5 = cdlk4.pop(0);
        System.out.println("Deve ter removido valor 0 do último index: ");
        cdlk2.printList();
        System.out.println("E deve ter retornado valor 0: " + String.valueOf(val5 == 0));
        System.out.println("Lista deve conter 0 elementos: " + String.valueOf(cdlk4.getSize() == 0));
        
        System.out.println("====== Teste DoublyLinkedList - método \"printFirst\" ======");
        System.out.println("Para a lista: ");
        cdlk1.printList();
        cdlk1.printFirst();
        
        System.out.println("====== Teste DoublyLinkedList - método \"printLast\" ======");
        System.out.println("Para a lista: ");
        cdlk1.printList();
        cdlk1.printLast();

    }

    @Test
    public void testPopFirst(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        
        CircularDoublyLinkedList<Integer> cdlk = new CircularDoublyLinkedList<Integer>(list);

        int v1 = cdlk.popFirst();
        assertEquals(cdlk.getSize(), 3);
        assertEquals(v1, 1);
    }

    @Test
    public void testPopLast(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        
        CircularDoublyLinkedList<Integer> cdlk = new CircularDoublyLinkedList<Integer>(list);

        int v1 = cdlk.popLast();
        assertEquals(cdlk.getSize(), 3);
        assertEquals(v1, 4);
    }

    @Test
    public void testInsertFirst(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        
        CircularDoublyLinkedList<Integer> cdlk = new CircularDoublyLinkedList<Integer>(list);

        cdlk.insertFirst(0);
        assertEquals(cdlk.getSize(), 5);
        int v1 = cdlk.get(0);
        assertEquals(v1, 0);
    }

    @Test
    public void testInsertLast(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        
        CircularDoublyLinkedList<Integer> cdlk = new CircularDoublyLinkedList<Integer>(list);

        cdlk.insertLast(0);
        assertEquals(cdlk.getSize(), 5);
        int v1 = cdlk.get(cdlk.getSize() - 1);
        assertEquals(v1, 0);
    }
}