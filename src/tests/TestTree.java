package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import main.Tree.Node;
import main.Tree.Tree;

public class TestTree{
    public static void main(String[] args) {
        // testTreeDefaultFunctions();
        p3();
    }

    public static void p3(){
        Node<Integer> n1 = new Node<Integer>(1); 
        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
    }

    public static void testTreeDefaultFunctions(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n4 = n3.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();

        /*    Árvore

         *       (1)         
         *      /   \         
         *     (2) (5)         
         *    /  \   \         
         *   (3) (4) (6)         
         *  /  \       \         
         *(8)  (9)     (7)         
        */
        System.out.println("Árvore: \n");
        System.out.println("       (1)      ");
        System.out.println("      /  \\     ");
        System.out.println("     (2) (5)    ");
        System.out.println("    /  \\   \\    ");
        System.out.println("   (3) (4) (6)  ");
        System.out.println("  /  \\       \\  ");
        System.out.println("(8)  (9)     (7)\n");

        System.out.println("============ Test - tree.printChildren ============");
        System.out.print("Filhos da raiz são 2 e 5: ");
        tree.printChildren(n1);
        System.out.print("Filhos do primeiro filho são 3 e 4: ");
        tree.printChildren(n1.getFirstChild());
        System.out.print("Filho do segundo filho é 6: ");
        tree.printChildren(n1.getFirstChild().getNextSibling());
        System.out.print("Filho do primeiro filho do segundo filho é 7: ");
        tree.printChildren(n1.getFirstChild().getNextSibling().getFirstChild());
        System.out.print("Filho do primeiro filho do primeiro filho são 8 e 9: ");
        tree.printChildren(n3);
        System.out.println("\n\n============ Test - tree.getFather e tree.printFather ============");
        System.out.print("Parente do nó (1) deve ser null: " +  String.valueOf(tree.getFather(n1) == null) + " - ");
        tree.printFather(n1);
        System.out.print("Parente do nó (7) deve ser (6): " +  String.valueOf(tree.getFather(n7).getValue() == 6) + " - ");
        tree.printFather(n7);
        System.out.print("Parente do nó (4) deve ser (2): " +  String.valueOf(tree.getFather(n4).getValue() == 2) + " - ");
        tree.printFather(n4);
        System.out.print("Parente do nó (3) deve ser (2): " +  String.valueOf(tree.getFather(n3).getValue() == 2) + " - ");
        tree.printFather(n3);
        System.out.print("Parente do nó (2) deve ser (1): " +  String.valueOf(tree.getFather(n2).getValue() == 1) + " - ");
        tree.printFather(n2);
        
        System.out.println("\n\n============ Test - tree.nodeIsIntern ============");
        System.out.println("Nó (1) não é interno: " + String.valueOf(tree.nodeIsIntern(n1) == false));
        System.out.println("Nó (4) não é interno: " + String.valueOf(tree.nodeIsIntern(n4) == false));
        System.out.println("Nó (2) é interno: " + String.valueOf(tree.nodeIsIntern(n2) == true));
        System.out.println("Nó (6) é interno: " + String.valueOf(tree.nodeIsIntern(n6) == true));
        System.out.println("Nó (7) não é interno: " + String.valueOf(tree.nodeIsIntern(n7) == false));
        
        System.out.println("\n\n============ Test - node.isLeaf ============");
        System.out.println("Nó (1) não é folha: " + String.valueOf(n1.isLeaf() == false));
        System.out.println("Nó (4) é folha: " + String.valueOf(n4.isLeaf() == true));
        System.out.println("Nó (6) não é folha: " + String.valueOf(n6.isLeaf() == false));
        System.out.println("Nó (7) é folha: " + String.valueOf(n7.isLeaf() == true));
        
        System.out.println("\n\n============ Test - tree.printLeafChildren ============");
        System.out.print("Para o nó (1), exibir lista vazia: ");
        
        tree.printChildren(n1);
        System.out.print("Para o nó (2), exibir apenas nó (4): ");
        tree.printChildren(n2);
        System.out.print("Para o nó (7), exibir lista vazia: ");
        tree.printChildren(n7);
        System.out.print("Para o nó (3), exibir nós 8 e 9: ");
        tree.printChildren(n3);
        
        System.out.println("\n\n============ Test - tree.printPreorder ============");
        System.out.print("Para o nó (1), exibir lista 1-2-3-8-9-4-5-6-7: ");
        tree.printPreorder(n1);
        System.out.print("Para o nó (8), exibir lista 8-9-4-5-6-7: ");
        tree.printPreorder(n8);
        System.out.print("Para o nó (7), exibir lista 7: ");
        tree.printPreorder(n7);
        System.out.print("Para o nó (6), exibir lista 6-7: ");
        tree.printPreorder(n6);
        
        System.out.println("\n\n============ Test - tree.printPosorder ============");
        System.out.print("Para o nó (8), exibir lista 8-9-3-4-2-7-6-5-1: ");
        tree.printPosorder(n8);
        System.out.print("Para o nó (4), exibir lista 4-2-7-6-5-1: ");
        tree.printPosorder(n4);
        System.out.print("Para o nó (6), exibir lista 6-5-1: ");
        tree.printPosorder(n6);
        System.out.print("Para o nó (1), exibir lista 1: ");
        tree.printPosorder(n1);
    }

    @Test
    public void testGetAllSiblings(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7)         
        */

        ArrayList<Integer> arrList = tree.getAllSiblings(n3);
        assertEquals(arrList.size(), 3);
        arrList = tree.getAllSiblings(n5);
        assertEquals(arrList.size(), 2);
        arrList = tree.getAllSiblings(n7);
        assertEquals(arrList.size(), 1);
        
    }

    @Test
    public void testGetAllInternals(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7)         
        */

        ArrayList<Integer> arrList = tree.getAllInternals(n1);
        assertEquals(arrList.size(), 4);
        arrList = tree.getAllInternals(n2);
        assertEquals(arrList.size(), 1);
        arrList = tree.getAllInternals(n3);
        assertEquals(arrList.size(), 0);
        
    }

    @Test
    public void testGetAllAncestors(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7)         
        */

        ArrayList<Integer> arrList = tree.getAllAncestors(n1);
        assertEquals(arrList.size(), 0);
        arrList = tree.getAllAncestors(n7);
        assertEquals(arrList.size(), 3);
        arrList = tree.getAllAncestors(n4);
        assertEquals(arrList.size(), 2);
        
    }

    @Test
    public void testGetAllDownwards(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7)         
        */

        ArrayList<Integer> arrList = tree.getAllDownwards(n1);
        assertEquals(arrList.size(), 9);
        arrList = tree.getAllDownwards(n6);
        assertEquals(arrList.size(), 1);
        arrList = tree.getAllDownwards(n2);
        assertEquals(arrList.size(), 5);
        arrList = tree.getAllDownwards(n9);
        assertEquals(arrList.size(), 0);
        
    }
    
    @Test
    public void testGetDepth(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7)         
        */

        int depth = tree.getDepth(n1);
        assertEquals(depth, 0);
        depth = tree.getDepth(n5);
        assertEquals(depth, 1);
        depth = tree.getDepth(n4);
        assertEquals(depth, 2);
        depth = tree.getDepth(n9);
        assertEquals(depth, 3);
        
    }

    @Test
    public void testGetHeight(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);
        tree.addChild(n1.getFirstChild().getFirstChild().getFirstChild().getNextSibling(), 11);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();
        Node<Integer> n11 = n9.getFirstChild();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7) 
                 \       
                (11) 
        */

        int depth = tree.getHeight(n1);
        assertEquals(depth, 4);
        depth = tree.getHeight(n3);
        assertEquals(depth, 2);
        depth = tree.getHeight(n5);
        assertEquals(depth, 2);
        depth = tree.getHeight(n11);
        assertEquals(depth, 0);
        
    }

    @Test
    public void testGetTreeHeight(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);
        tree.addChild(n1.getFirstChild().getFirstChild().getFirstChild().getNextSibling(), 11);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();
        Node<Integer> n11 = n9.getFirstChild();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7) 
                 \       
                (11) 
        */

        int depth = tree.getTreeHeight();
        assertEquals(depth, 4);

        Tree<Integer> tree2 = new Tree<Integer>();
        assertEquals(tree2.getTreeHeight(), 0);
        
        Node<Integer> nodeTree3 = new Node<Integer>(9);
        Tree<Integer> tree3 = new Tree<Integer>(nodeTree3);
        assertEquals(tree3.getTreeHeight(), 0);
        tree3.addChild(nodeTree3, 2);
        assertEquals(tree3.getTreeHeight(), 1);
        
    }

    @Test
    public void testGetSize(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);
        tree.addChild(n1.getFirstChild().getFirstChild().getFirstChild().getNextSibling(), 11);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();
        Node<Integer> n11 = n9.getFirstChild();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7) 
                 \       
                (11) 
        */

        assertEquals(tree.getSize(), 11);

        Tree<Integer> tree2 = new Tree<Integer>();
        assertEquals(tree2.getSize(), 0);
        
        Node<Integer> nodeTree3 = new Node<Integer>(9);
        Tree<Integer> tree3 = new Tree<Integer>(nodeTree3);
        assertEquals(tree3.getSize(), 1);
        tree3.addChild(nodeTree3, 2);
        assertEquals(tree3.getSize(), 2);
    }

    @Test
    public void testGetRoot(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);
        tree.addChild(n1.getFirstChild().getFirstChild().getFirstChild().getNextSibling(), 11);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();
        Node<Integer> n11 = n9.getFirstChild();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7) 
                 \       
                (11) 
        */

        int rootVal = tree.getRoot();
        assertEquals(rootVal, 1);

        Tree<Integer> tree2 = new Tree<Integer>();
        try{
            rootVal = tree2.getRoot();
            assertFalse(true);
        }
        catch(Exception e){
            assertTrue(true);
        }
        
        Node<Integer> nodeTree3 = new Node<Integer>(9);
        Tree<Integer> tree3 = new Tree<Integer>(nodeTree3);
        rootVal = tree3.getRoot();
        assertEquals(rootVal, 9);
        tree3.addChild(nodeTree3, 2);
        rootVal = tree3.getRoot();
        assertEquals(rootVal, 9);
    }

    @Test
    public void testGetAllChildren(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);
        tree.addChild(n1.getFirstChild().getFirstChild().getFirstChild().getNextSibling(), 11);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();
        Node<Integer> n11 = n9.getFirstChild();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7) 
                 \       
                (11) 
        */

        ArrayList<Integer> arr = tree.getAllChildren(n1);
        assertEquals(arr.size(), 2);
        arr = tree.getAllChildren(n2);
        assertEquals(arr.size(), 3);
        arr = tree.getAllChildren(n9);
        assertEquals(arr.size(), 1);
        arr = tree.getAllChildren(n11);
        assertEquals(arr.size(), 0);
    }

    @Test
    public void testIsEmpty(){
        Tree<Integer> tree3 = new Tree<Integer>();
        assertTrue(tree3.isEmpty());
        tree3.addChild(2);
        assertFalse(tree3.isEmpty());
    }

    @Test
    public void testGetAllNodes(){
        Node<Integer> n1 = new Node<Integer>(1); 

        Tree<Integer> tree = new Tree<Integer>(n1);
        tree.addChild(n1, 2);
        tree.addChild(n1.getFirstChild(), 3);
        tree.addChild(n1.getFirstChild(), 10);
        tree.addChild(n1.getFirstChild(), 4);
        tree.addChild(n1, 5);
        tree.addChild(n1.getFirstChild().getNextSibling(), 6);
        tree.addChild(n1.getFirstChild().getNextSibling().getFirstChild(), 7);
        tree.addChild(n1.getFirstChild().getFirstChild(), 8);
        tree.addChild(n1.getFirstChild().getFirstChild(), 9);
        tree.addChild(n1.getFirstChild().getFirstChild().getFirstChild().getNextSibling(), 11);

        Node<Integer> n2 = n1.getFirstChild();
        Node<Integer> n3 = n2.getFirstChild();
        Node<Integer> n10 = n3.getNextSibling();
        Node<Integer> n4 = n10.getNextSibling();
        Node<Integer> n5 = n2.getNextSibling();
        Node<Integer> n6 = n5.getFirstChild();
        Node<Integer> n7 = n6.getFirstChild();
        Node<Integer> n8 = n3.getFirstChild();
        Node<Integer> n9 = n8.getNextSibling();
        Node<Integer> n11 = n9.getFirstChild();

        /*    Árvore

         *          (1)         
         *         /  \         
         *       (2)  (5)         
         *      / | \   \         
         *   (3)(10)(4) (6)         
         *  /  \          \         
         *(8)  (9)        (7) 
                 \       
                (11) 
        */

        ArrayList<Integer> arr = tree.getAllNodes();
        assertEquals(arr.size(), 11);
        
        Tree<Integer> tree2 = new Tree<Integer>();
        arr = tree2.getAllNodes();
        assertEquals(arr.size(), 0);
        
        Node<Integer> nodeTree3 = new Node<Integer>(9);
        Tree<Integer> tree3 = new Tree<Integer>(nodeTree3);
        arr = tree3.getAllNodes();
        assertEquals(arr.size(), 1);
        tree3.addChild(nodeTree3, 2);
        arr = tree3.getAllNodes();
        assertEquals(arr.size(), 2);
    }
}