package tests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.BinarySearchTree.BinarySearchTree;




public class TestBinarySearchTree {
    public static void main(String[] args) {
        
        System.out.println("====== Ex1 - implementar árvore a partir de vetor ======");
        int[] arr = {3, 7, 8, 9, 10, 5};
        BinarySearchTree t = new BinarySearchTree(arr);
        System.out.println("Tamanho da árvore tem que ser 6: " + String.valueOf(t.getLength()));
        
        System.out.println("\n====== Ex2 - método \"add\" ======");
        /*
        Árvore:
                    5
                /      \    
            0              10
             \            /
              3         7
             / \         \
            2   4         8
           /               \
          1                 9

        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(0);
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(8);
        tree.add(9);
        System.out.println("Tamanho da árvore tem que ser 10: " + String.valueOf(tree.getLength()));
        tree.add(11);
        System.out.println("Ao inserir valor não duplicado, tamanho = 11: " + String.valueOf(tree.getLength()));
        tree.add(10);
        System.out.println("Ao inserir valor duplicado, tamanho = 11: " + String.valueOf(tree.getLength()));

        System.out.println("\n====== Ex3 - método \"preOrder\" ======");
        tree.preOrder();

        System.out.println("\n====== Ex4- método \"posOrder\" ======");
        tree.posOrder();
        
        System.out.println("\n====== Ex5 - método \"inOrder\" ======");
        tree.inOrder();
        
        System.out.println("\n====== Ex6 - método \"isIn\" ======");
        int valor_em_analise;
        valor_em_analise = 5;
        System.out.println("Valor " +  String.valueOf(valor_em_analise) + " está na árvore: " + String.valueOf(tree.isIn(valor_em_analise) == true));
        valor_em_analise = 1;
        System.out.println("Valor " +  String.valueOf(valor_em_analise) + " está na árvore: " + String.valueOf(tree.isIn(valor_em_analise) == true));
        valor_em_analise = 9;
        System.out.println("Valor " +  String.valueOf(valor_em_analise) + " está na árvore: " + String.valueOf(tree.isIn(valor_em_analise) == true));
        valor_em_analise = 3;
        System.out.println("Valor " +  String.valueOf(valor_em_analise) + " está na árvore: " + String.valueOf(tree.isIn(valor_em_analise) == true));
        valor_em_analise = 4;
        System.out.println("Valor " +  String.valueOf(valor_em_analise) + " está na árvore: " + String.valueOf(tree.isIn(valor_em_analise) == true));
        valor_em_analise = 10;
        System.out.println("Valor " +  String.valueOf(valor_em_analise) + " está na árvore: " + String.valueOf(tree.isIn(valor_em_analise) == true));
        valor_em_analise = 12;
        System.out.println("Valor " +  String.valueOf(valor_em_analise) + " não está na árvore: " + String.valueOf(tree.isIn(valor_em_analise) == false));
        valor_em_analise = -1;
        System.out.println("Valor " +  String.valueOf(valor_em_analise) + " não está na árvore: " + String.valueOf(tree.isIn(valor_em_analise) == false));
        valor_em_analise = 6;
        System.out.println("Valor " +  String.valueOf(valor_em_analise) + " não está na árvore: " + String.valueOf(tree.isIn(valor_em_analise) == false));
        
        System.out.println("\n====== Ex7 - método \"smaller\" ======");
        System.out.println("Menor valor deve ser 0: " + String.valueOf(tree.smaller() == 0));
        
        System.out.println("\n====== Ex8 - método \"getLength\" ======");
        System.out.println("Tamanho da árvore de exemplo deve ser 11: " + String.valueOf(tree.getLength() == 11));
        
        System.out.println("\n====== Ex9 - método \"mean\" ======");
        System.out.println("Valor da média deve ser próximo de 5.45: " + String.valueOf(tree.mean()));
        
        System.out.println("\n====== Ex10 - método \"getHeight\" ======");
        System.out.println("Valor da altura da árvore deve ser 4: " + String.valueOf(tree.getHeight() == 4));
        
        System.out.println("\n====== Ex11 - método \"nullCount\" ======");
        System.out.println("Número de nulls deve ser 11: " + String.valueOf(12 == tree.nullCount()));
        
        System.out.println("\n====== Ex12 - método \"getTwoMultiples\" ======");
        System.out.println("Número de nós deve ser 5: " + String.valueOf(tree.getTwoMultiples() == 5));
        
        System.out.println("\n====== Ex13 - método \"getSum\" ======");
        System.out.println("A soma dos nós na árvore deve ser 60: " +  String.valueOf(tree.getSum() == 60));
    }   


    @Test
    public void testPopCase1_RemovingLeaf(){
        /*
        Árvore:
                    5
                /      \    
            0              10
             \            /
              3         7
             / \         \
            2   4         8
           /               \
          1                 9

        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(0);
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(8);
        tree.add(9);

        tree.pop(1);
        assertEquals(9, tree.getLength());
        assertEquals(false, tree.isIn(1));
    }

    @Test
    public void testPopCase1_RemovingRootLeaf(){
        /*
        Árvore:
                    5
                /      \    
            0              10
             \            /
              3         7
             / \         \
            2   4         8
           /               \
          1                 9

        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);

        tree.pop(5);
        assertEquals(0, tree.getLength());
        assertEquals(false, tree.isIn(5));
    }
}
