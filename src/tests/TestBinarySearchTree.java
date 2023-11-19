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

        tree.pop(9);
        assertEquals(8, tree.getLength());
        assertEquals(false, tree.isIn(9));
        tree.inOrder();

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
        tree.inOrder();

    }

    @Test
    public void testPopCase2A(){
        /*
        Árvore:
                    5
                /      \    
              3        10
            /  \      /
           2    4    7
          /           \
         1             8
        /               \
       0                 9

        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(1);
        tree.add(0);
        tree.add(4);
        tree.add(8);
        tree.add(9);

        // removing value 2
        tree.pop(2);
        assertEquals(9, tree.getLength());
        assertEquals(false, tree.isIn(2));
        
        // removing value 1
        tree.pop(1);
        assertEquals(8, tree.getLength());
        assertEquals(false, tree.isIn(1));
        
        // print in order
        tree.inOrder();

    }

    @Test
    public void testPopCase2B(){
        /*
        Árvore:
                    5
                /      \    
              3        10
            /  \      /
           2    4    7
          /           \
         1             8
        /               \
       0                 9

        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(1);
        tree.add(0);
        tree.add(4);
        tree.add(8);
        tree.add(9);

        // removing value 7
        tree.pop(7);
        assertEquals(9, tree.getLength());
        assertEquals(false, tree.isIn(7));
        
        // removing value 8
        tree.pop(8);
        assertEquals(8, tree.getLength());
        assertEquals(false, tree.isIn(8));
        
        // print in order
        tree.inOrder();

    }

    @Test
    public void testPopCase2A_Root(){
        /*
        Árvore:
                    5
                /          
              3        
            /  \      
           2    4    
          /           
         1             
        /               
       0                 

        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(0);
        tree.add(4);

        // removing value 5
        tree.pop(5);
        assertEquals(5, tree.getLength());
        assertEquals(false, tree.isIn(5));
        
        // print in order
        tree.inOrder();

    }

    @Test
    public void testPopCase2B_Root(){
        /*
        Árvore:
                    5
                      \    
                      10
                      /
                     7
                     \
                      8
                       \
                        9

        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(10);
        tree.add(7);
        tree.add(8);
        tree.add(9);

        // removing value 5
        tree.pop(5);
        assertEquals(4, tree.getLength());
        assertEquals(false, tree.isIn(5));
        
        // print in order
        tree.inOrder();

    }
    @Test
    public void testPopCase3_ex1(){
        /*
        Árvore:
                    5
                /      \    
              3        10
            /  \      /
           2    4    7
          /           \
         1             8
        /               \
       0                 9

        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(1);
        tree.add(0);
        tree.add(4);
        tree.add(8);
        tree.add(9);

        // removing value 3
        tree.pop(3);
        assertEquals(9, tree.getLength());
        assertEquals(false, tree.isIn(3));
        
        // print in order
        tree.inOrder();

    }

    @Test
    public void testPopCase3_ex2(){
        /*
        Árvore:
                        50 
                   /         \
                 30           90
              /     \       /   \
          20         40   85     95
        /   \       /  \
      10     25   39    41

        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(10);
        tree.add(25);
        tree.add(40);
        tree.add(39);
        tree.add(41);
        tree.add(90);
        tree.add(85);
        tree.add(95);

        // removing value 30
        tree.pop(30);
        assertEquals(10, tree.getLength());
        assertEquals(false, tree.isIn(30));
        
        // print in order
        tree.inOrder();

    }
    
    @Test
    public void testPopCase3_ex3(){
        /*
        Árvore:
        5
        /      \    
        3        10
            /  \      /
           2    4    7
           /           \
           1             8
           /               \
           0                 9
           
           */
          BinarySearchTree tree = new BinarySearchTree();
          tree.add(5);
          tree.add(10);
          tree.add(3);
          tree.add(7);
          tree.add(2);
          tree.add(1);
          tree.add(0);
          tree.add(4);
          tree.add(8);
          tree.add(9);
          
          // removing value 5
          tree.pop(5);
          assertEquals(9, tree.getLength());
          assertEquals(false, tree.isIn(5));
          
          // print in order
          tree.inOrder();

        }
    @Test
    public void testPopCase3_ex4(){
        /*
        Árvore:
                        
                        8
                    /       \
                   3          11
                /   \     /      \
              1     5    9       14
                     \    \     /  \
                      6   10  12   15
                       \        \
                        7       13
        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(11);
        tree.add(9);
        tree.add(10);
        tree.add(14);
        tree.add(12);
        tree.add(13);
        tree.add(15);


        // removing value 11
        tree.pop(11);
        assertEquals(12, tree.getLength());
        assertEquals(false, tree.isIn(11));
        
        // print in order
        tree.inOrder();

    }
    @Test
    public void testPopCase3_ex5(){
        /*
        Árvore:
                        
                            50
                          /   \
                        30    100
                      /   \ 
                    20    40
                        /   \
                      35     45 
                        \ 
                        37
        */
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(35);
        tree.add(37);
        tree.add(45);
        tree.add(100);

        // removing value 30
        tree.pop(30);
        assertEquals(7, tree.getLength());
        assertEquals(false, tree.isIn(30));
        
        // print in order
        tree.inOrder();

    }
}
    