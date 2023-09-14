package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import main.LinkedList.LinkedList;

public class TestLinkedList{
    @Test
    public void testNotUnit(){
        // Criando a lista ligada
        System.out.println("====== Teste - Criação da Lista Ligada ======");
        String n1 = "Joao";
        String n2 = "Pedro"; 
        String n3 = "Carlos"; 
        String n4 = "Jose"; 
        Integer n5 = 2;
        
        LinkedList<String> lk = new LinkedList<String>(new ArrayList<>(Arrays.asList(n1, n2, n3, n4)));
        LinkedList<String> lk2 = new LinkedList<String>();
        LinkedList<Integer> lk3 = new LinkedList<Integer>(n5);
        lk.printList();
        
        // Testando método "add"
        System.out.println("\n\n====== Teste - Método \"addLast\" ======");
        System.out.println("Teste 1");
        lk.addLast("Vitor");
        lk.printList();
        
        String n6 = "Joao";
        System.out.println("\nTeste 2");
        lk2.addLast(n6);
        lk2.printList();
        
        System.out.println("\nTeste 3");
        Integer n7 = 4;
        lk3.addLast(n7);
        lk3.printList();


        // Testando método "get"
        System.out.println("\n====== Teste - Método \"get\" ======");
        System.out.println("Index 0: " + lk.get(0));
        System.out.println("Index 1: " + lk.get(1));
        System.out.println("Index 4: " + lk.get(4));
        
        System.out.println("\n====== Teste - Método \"get\" - Erro ======");
        lk.get(-1);
        lk.get(10);

        // Testando método "pop"
        System.out.println("\n====== Teste - Método \"pop\" ======");
        System.out.println("Teste 1");
        lk2.printList();
        System.out.println("\nRetirando o seguinte valor do index 0: "+lk2.pop(0));
        lk2.printList();
        
        System.out.println("\n\nTeste 2");
        lk.printList();
        System.out.println("\nRetirando o seguinte valor do index 3: "+lk.pop(3));
        lk.printList();
        
        System.out.println("\n\nTeste 3");
        lk.printList();
        System.out.println("\nRetirando o seguinte valor do último index: "+lk.pop(3));
        lk.printList();
        
        System.out.println("\n\n====== Teste - Método \"pop\" - Erro ======");
        lk.pop(-2);
        lk.pop(10);
        
        // Testando método "insert"
        System.out.println("\n\n====== Teste - Método \"insert\" ======");
        System.out.println("Teste 1");
        lk2.printList();
        System.out.println("\nInserindo o seguinte valor Mesquita no index 0: ");
        lk2.insert(0, "Mesquita");
        lk2.printList();
        
        System.out.println("\n\nTeste 2");
        lk2.printList();
        System.out.println("\nInserindo o seguinte valor Erick no index 1: ");
        lk2.insert(1, "Erick");
        lk2.printList();
        
        System.out.println("\n\nTeste 3");
        lk.printList();
        System.out.println("\nInserindo o seguinte valor Erick no index 3: ");
        lk.insert(3, "Erick");
        lk.printList();
        
        System.out.println("\n\n====== Teste - Método \"insert\" - Erro ======");
        lk.insert(-2, "Erick");
        lk.insert(100, "Erick");
        
        // Testando construtor com Arraylist<Node<T>>
        System.out.println("\n\n====== Teste - Criando Lista Ligada a partir de ArrayList ======");
        System.out.println("Teste 1");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        LinkedList<Integer> lk4 = new LinkedList<Integer>(list);
        lk4.printList();
        System.out.println("\nTamanho da lista: "+lk4.getLen());;
        
        System.out.println("\nTeste 2");
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        LinkedList<Integer> lk5 = new LinkedList<Integer>(list2);
        lk5.printList();
        System.out.println("\nTamanho da lista: "+lk5.getLen());;
        
        System.out.println("\nTeste 3");
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(1); 
        LinkedList<Integer> lk6 = new LinkedList<Integer>(list3);
        lk6.printList();
        System.out.println("\nTamanho da lista: "+lk6.getLen());

        // Testando método "update"
        System.out.println("\n\n====== Teste - Método \"update\" ======");
        System.out.println("Teste 1");
        lk.printList();
        System.out.println("\nAtualizando o valor do index 0 para Erick: ");
        lk.update(0, "JhonsonsAndJhonsons");
        lk.printList();

        // Testando método "addFirst"
        System.out.println("\n\n====== Teste - Método \"addFirst\" ======");
        System.out.println("Teste 1");
        lk.printList();
        System.out.println("\nAdicionando o valor Vitor no início da lista: ");
        lk.addFirst("Vitor");
        lk.printList();
        
        System.out.println("Teste 2");
        System.out.println("\nAdicionando o valor Tiago no início da lista: ");
        lk.addFirst("Tiago");
        lk.printList();
        lk.pop(2);

        // Testando método "popFirst"
        System.out.println("\n\n====== Teste - Método \"popFirst\" ======");
        System.out.println("Teste 1");
        lk.printList();
        System.out.println("\nRetirando o valor do início da lista: ");
        lk.popFirst();
        lk.printList();
        
        System.out.println("\nTeste 2");
        lk6.printList();
        System.out.println("\nRetirando o valor do início da lista: ");
        lk6.popFirst();
        lk6.printList();

        System.out.println("\nTeste 3");
        lk6.addFirst(1);
        lk6.addFirst(2);
        lk6.printList();
        System.out.println("\nRetirando o valor do início da lista: ");
        lk6.popFirst();
        lk6.printList();

        // Testando método "popLast"
        System.out.println("\n\n====== Teste - Método \"popLast\" ======");
        System.out.println("Teste 1");
        lk.printList();
        System.out.println("\nRetirando o valor do final da lista: ");
        lk.popLast();
        lk.printList();
 
        System.out.println("\nTeste 2");
        lk6.printList();
        System.out.println("\nRetirando o valor do final da lista: ");
        lk6.popLast();
        lk6.printList();

        System.out.println("\nTeste 3");
        lk6.addLast(1);
        lk6.addLast(2);
        lk6.printList();
        System.out.println("\nRetirando o valor do final da lista: ");
        lk6.popLast();
        lk6.printList();
    }
}