package tests;

import main.BinaryTree.BinaryTree;
import main.BinaryTree.BinaryTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinaryTree {

    @Test
    @DisplayName("Teste - Criação da Árvore Binária")
    void testTree() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        assert tree.getSize() == 0;
        assert tree.getRoot() == null;
    }

    @Test
    @DisplayName("Teste - Criação da Árvore Binária com value")
    void testTreeValue() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(1);
        assert tree.getSize() == 1;
        assert tree.getRoot().getValue() == 1;
    }

    @Test
    @DisplayName("Teste - Criação da Árvore Binária com root")
    void testTreeRoot() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1));
        assert tree.getSize() == 1;
        assert tree.getRoot().getValue() == 1;

        tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode(3)));
        assert tree.getSize() == 3;
        assert tree.getRoot().getValue() == 1;

        tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode(4)), new BinaryTreeNode(5)));
        assert tree.getSize() == 5;
        assert tree.getRoot().getValue() == 1;
    }

    @Test
    @DisplayName("Teste - Criação da Árvore Binária com root e value")
    void setRoot() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        assert tree.getSize() == 0;

        tree.setRoot(new BinaryTreeNode<Integer>(1));
        assert tree.getSize() == 1;

        tree.setRoot(null);
        assert tree.getSize() == 0;

        tree.setRoot(new BinaryTreeNode<Integer>(1));
        assert tree.getSize() == 1;

        tree.setRoot(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3)));
        assert tree.getSize() == 3;

        tree.setRoot(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode(4)), new BinaryTreeNode(5)));
        assert tree.getSize() == 5;
    }

    @Test
    @DisplayName("Teste - Criação da Árvore Binária sem")
    void isEmpty() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        assert tree.isEmpty();

        tree.setRoot(new BinaryTreeNode<Integer>(1));
        assert !tree.isEmpty();
        
        tree.setRoot(null);
        assert tree.isEmpty();
    }
    
    @Test
    @DisplayName("Teste - método Add")
    void add(){
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1);
        tree.setRoot(node);
        tree.add(2, node);
        tree.add(3, node);
        tree.add(4, node);
        tree.add(5, node);

        assert tree.getSize() == 5;
        assert tree.getRoot().getValue() == 1;
        assert tree.getRoot().getLeft().getValue() == 2;
        assert tree.getRoot().getRight().getValue() == 3;
        assert tree.getRoot().getLeft().getLeft().getValue() == 4;
        assert tree.getRoot().getLeft().getRight().getValue() == 5;

    }

    @Test
    @DisplayName("Teste - Algortimo de PosOrder")
    void posOrder() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5)));

        assert "3 4 2 5 1 ".equals(tree.posOrder());
        assert "3 4 2 ".equals(tree.posOrder(tree.getRoot().getLeft()));
    }

    @Test
    @DisplayName("Teste - Algortimo de PreOrder")
    void preOrder() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5)));

        assert "1 2 3 4 5 ".equals(tree.preOrder());
        assert "2 3 4 ".equals(tree.preOrder(tree.getRoot().getLeft()));
    }

    @Test
    @DisplayName("Teste - Algortimo de InOrder")
    void inOrder() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5)));

        assert "3 2 4 1 5 ".equals(tree.inOrder());
        assert "3 2 4 ".equals(tree.inOrder(tree.getRoot().getLeft()));
    }

    @Test
    @DisplayName("Teste - Verifica se a árvore é cheia")
    void isFull() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5)));
        assert !tree.isFull();

        tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5, new BinaryTreeNode<Integer>(6), new BinaryTreeNode<Integer>(7))));
        assert tree.isFull();
    }

    @Test
    @DisplayName("Teste - Verificar a altura da árvore")
    void getHeight() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5)));
        assert tree.getHeight() == 2;

        tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5, new BinaryTreeNode<Integer>(6), new BinaryTreeNode<Integer>(7))));
        assert tree.getHeight() == 2;
    }

    @Test
    @DisplayName("Teste - Verificar se K está na árvore")
    void contains() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5)));
        assert tree.contains(1);
        assert tree.contains(2);
        assert tree.contains(3);
        assert tree.contains(4);
        assert tree.contains(5);
        assert !tree.contains(6);
    }

    @Test
    @DisplayName("Teste - Quantidade de nós folha")
    void getLeafCount() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1));
        assertEquals(1, tree.getLeafCount());

        tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3)));
        assertEquals(2, tree.getLeafCount());

        tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5)));
        assertEquals(3, tree.getLeafCount());
    }

    @Test
    @DisplayName("Teste - Quantidade de nós internos")
    void getInternalNodeCount() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1));
        assertEquals(0, tree.getInternalNodeCount());

        tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3)));
        assertEquals(1, tree.getInternalNodeCount());

        tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3), new BinaryTreeNode<Integer>(4)), new BinaryTreeNode<Integer>(5)));
        assertEquals(2, tree.getInternalNodeCount());
    }

    @Test
    @DisplayName("Teste - Quantidade de nulos")
    void getNullNodeCount() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1));
        assertEquals(2, tree.getNullNodeCount());

        tree = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3)));
        assertEquals(4, tree.getNullNodeCount());
    }


    @Test
    @DisplayName("Teste - Cria uma árvore binária")
    void ex1(){
        BinaryTree<Integer> tree = new BinaryTree<Integer>(0, new BinaryTreeNode<Integer>(1), new BinaryTreeNode<Integer>(2, new BinaryTreeNode<Integer>(3, new BinaryTreeNode<Integer>(5), new BinaryTreeNode<Integer>(6)), new BinaryTreeNode<Integer>(4)));

        String preOrder = tree.preOrder();
        assert preOrder.equals("0 1 2 3 5 6 4 ");

        String posOrder = tree.posOrder();
        assert posOrder.equals("1 5 6 3 4 2 0 ");

        String inOrder = tree.inOrder();
        assert inOrder.equals("1 0 5 3 6 2 4 ");
    }

    @Test
    @DisplayName("Teste - É prórpia ou não")
    void propperAndImpropper(){
        BinaryTree<Integer> tree = new BinaryTree<>(0, new BinaryTreeNode<Integer>(1), new BinaryTreeNode<Integer>(2));
        tree.getRoot().getLeft().setLeft(new BinaryTreeNode<Integer>(3));
        assert !tree.isProper();
        assert tree.isImproper();

        tree = new BinaryTree<Integer>(0, new BinaryTreeNode<Integer>(1), new BinaryTreeNode<Integer>(2));
        assert tree.isProper();
        assert !tree.isImproper();
    }

    @Test
    @DisplayName("Teste -Min and max node")
    void minAndMaxNode(){
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(0);
        node.setLeft(new BinaryTreeNode<Integer>(1));
        node.getLeft().setRight(new BinaryTreeNode<Integer>(2));

        BinaryTree<Integer> tree = new BinaryTree<Integer>(node);

        assertEquals(3, tree.minNodeCount());
        assertEquals(7, tree.maxNodeCount());
    }


}
