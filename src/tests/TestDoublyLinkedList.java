package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;

import org.junit.Test;

import main.DoublyLinkedList.DoublyLinkedList;

public class TestDoublyLinkedList {
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
        
        DoublyLinkedList<Integer> dlk1 = new DoublyLinkedList<Integer>(list);
        DoublyLinkedList<Integer> dlk2 = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> dlk3 = new DoublyLinkedList<Integer>();
        
        

        System.out.print("Para a lista: ");
        dlk1.printList();
        System.out.println("Lista deve ter 4 elementos: " + String.valueOf(dlk1.getSize() == 4));
        
        System.out.println("====== Teste DoublyLinkedList - método \"get\" ======");
        int v1 = dlk1.get(0);
        int v2 = dlk1.get(2);
        int v3 = dlk1.get(3);
        System.out.println("Index 0 deve ter valor 1: "+ String.valueOf(v1 == 1));
        System.out.println("Index 2 deve ter valor 3: "+ String.valueOf(v2 == 3));
        System.out.println("Index 3 deve ter valor 4: "+ String.valueOf(v3 == 4));
        System.out.println("Deve ter erro na mensagem abaixo: " + String.valueOf(null == dlk1.get(-1)));
        System.out.println("Deve ter erro na mensagem abaixo: " + String.valueOf(null == dlk1.get(10)));

        System.out.println("====== Teste DoublyLinkedList - método \"insert\" ======");
        Integer insert_1 = 0;
        Integer insert_2 = 100;
        Integer insert_3 = 5;
        Integer insert_6 = 101;
        
        System.out.println("Para a lista: ");
        dlk1.printList();
        
        dlk1.insert(0, insert_1);
        System.out.println("Deve ter inserido valor 0 no index 0: ");
        dlk1.printList();
        
        dlk1.insert(3, insert_2);
        System.out.println("Deve ter inserido valor 100 no index 2: ");
        dlk1.printList();
        
        dlk1.insert(dlk1.getSize() - 1, insert_3);
        System.out.println("Deve ter inserido valor 5 no último index: ");
        dlk1.printList();
        System.out.println("Lista deve conter 7 elementos: " + String.valueOf(dlk1.getSize() == 7));
        
        dlk1.insert(1, insert_6);
        System.out.println("Deve ter inserido valor 101 no index 1: ");
        dlk1.printList();
        System.out.println("Lista deve conter 8 elementos: " + String.valueOf(dlk1.getSize() == 8));
        
        System.out.println("Para a lista: ");
        dlk2.printList();
        Integer insert_4 = 0;
        dlk2.insert(0, insert_4);
        System.out.println("Deve ter inserido valor 0 no primeiro index: ");
        dlk2.printList();
        
        System.out.println("Para a lista: ");
        dlk3.printList();
        dlk3.insert(dlk3.getSize() - 1, insert_4);
        System.out.println("Deve ter inserido valor 0 no último index: ");
        dlk3.printList();
        System.out.println("Lista deve conter 1 elemento: " + String.valueOf(dlk3.getSize() == 1));
        
        
        System.out.println("====== Teste DoublyLinkedList - método \"pop\" ======");
        System.out.println("Para a lista: ");
        dlk1.printList();
        
        Integer val1 = dlk1.pop(0);
        System.out.println("Deve ter removido valor 0 do index 0: ");
        dlk1.printList();
        System.out.println("E deve ter retornado valor 0: " + String.valueOf(val1 == 0));
        
        Integer val2 = dlk1.pop(3);
        System.out.println("Deve ter removido valor 100 do index 2: ");
        dlk1.printList();
        System.out.println("E deve ter retornado valor 100: " + String.valueOf(val2 == 100));
        
        Integer val3 = dlk1.pop(dlk1.getSize() - 1);
        System.out.println("Deve ter removido valor 4 do último index: ");
        dlk1.printList();
        System.out.println("E deve ter retornado valor 4: " + String.valueOf(val3 == 4));
        
        Integer val6 = dlk1.pop(1);
        System.out.println("Deve ter removido valor 1 do index 1: ");
        dlk1.printList();
        System.out.println("E deve ter retornado valor 1: " + String.valueOf(val6 == 1));
        System.out.println("Lista deve conter 4 elementos: " + String.valueOf(dlk1.getSize() == 4));
        
        System.out.println("Para a lista: ");
        dlk2.printList();
        Integer val4 = dlk2.pop(0);
        System.out.println("Deve ter removido valor 0 do primeiro index: ");
        dlk2.printList();
        System.out.println("E deve ter retornado valor 0: " + String.valueOf(val4 == 0));
        System.out.println("Lista deve conter 0 elementos: " + String.valueOf(dlk2.getSize() == 0));
        
        System.out.println("Para a lista: ");
        dlk3.printList();
        Integer val5 = dlk3.pop(0);
        System.out.println("Deve ter removido valor 0 do último index: ");
        dlk2.printList();
        System.out.println("E deve ter retornado valor 0: " + String.valueOf(val5 == 0));
        System.out.println("Lista deve conter 0 elementos: " + String.valueOf(dlk3.getSize() == 0));
        
    }

    @Test
    public void testPopFirst(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        DoublyLinkedList<Integer> dlk1 = new DoublyLinkedList<Integer>(list);
        dlk1.popFirst();
        assertEquals(dlk1.getSize(), 3);
        int v1 = dlk1.get(0);
        assertEquals(v1, 2);
    }

    @Test
    public void testPopLast(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        DoublyLinkedList<Integer> dlk1 = new DoublyLinkedList<Integer>(list);
        dlk1.popLast();
        assertEquals(dlk1.getSize(), 3);
        int v1 = dlk1.get(2);
        assertEquals(v1, 3);
    }

    @Test
    public void testInsertFirst(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        DoublyLinkedList<Integer> dlk1 = new DoublyLinkedList<Integer>(list);
        dlk1.insertFirst(0);
        assertEquals(dlk1.getSize(), 5);
        int v1 = dlk1.get(0);
        assertEquals(v1, 0);
    }

    @Test
    public void testInsertLast(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        DoublyLinkedList<Integer> dlk1 = new DoublyLinkedList<Integer>(list);
        dlk1.insertLast(0);
        assertEquals(dlk1.getSize(), 5);
        int v1 = dlk1.get(dlk1.getSize() - 1);
        assertEquals(v1, 0);
        dlk1.printFirst();
    }
    
    @Test
    public void testGetAllElementsInverted(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        DoublyLinkedList<Integer> dlk1 = new DoublyLinkedList<Integer>(list);
        ArrayList<Integer> inverted = dlk1.getAllElementsInverted();
        assertEquals(inverted.size(), dlk1.getSize());
        for (int i = 0; i < inverted.size(); i++) {
            assertEquals(inverted.get(i), dlk1.get(dlk1.getSize() - 1 - i));
        }

        dlk1.pop(0);
        dlk1.pop(0);

        ArrayList<Integer> inverted2 = dlk1.getAllElementsInverted();
        assertEquals(inverted2.size(), dlk1.getSize());
        for (int i = 0; i < inverted2.size(); i++) {
            assertEquals(inverted2.get(i), dlk1.get(dlk1.getSize() - 1 - i));
        }

        dlk1.pop(0);

        ArrayList<Integer> inverted3 = dlk1.getAllElementsInverted();
        assertEquals(inverted3.size(), dlk1.getSize());
        for (int i = 0; i < inverted3.size(); i++) {
            assertEquals(inverted3.get(i), dlk1.get(dlk1.getSize() - 1 - i));
        }
        
    }
}
