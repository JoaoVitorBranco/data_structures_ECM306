package tests.BinaryTree;

import main.BinaryTree.BinaryTree;
import main.BinaryTree.BinaryTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinaryTree {

    @Test
    @DisplayName("Teste - Criação da Árvore Binária")
    void testTree() {
        BinaryTree tree = new BinaryTree();
        assert tree.getSize() == 0;
        assert tree.getRoot() == null;
    }

    @Test
    @DisplayName("Teste - Criação da Árvore Binária com value")
    void testTreeValue() {
        BinaryTree tree = new BinaryTree(1);
        assert tree.getSize() == 1;
        assert tree.getRoot().getValue() == 1;
    }

    @Test
    @DisplayName("Teste - Criação da Árvore Binária com root")
    void testTreeRoot() {
        BinaryTree tree = new BinaryTree(new BinaryTreeNode(1));
        assert tree.getSize() == 1;
        assert tree.getRoot().getValue() == 1;
    }

    @Test
    @DisplayName("Teste - Criação da Árvore Binária com root e value")
    void setRoot() {
        BinaryTree tree = new BinaryTree();
        assert tree.getSize() == 0;

        tree.setRoot(new BinaryTreeNode(1));
        assert tree.getSize() == 1;

        tree.setRoot(null);
        assert tree.getSize() == 0;

        tree.setRoot(new BinaryTreeNode(1));
        assert tree.getSize() == 1;

        tree.setRoot(new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3)));
        assert tree.getSize() == 3;

        tree.setRoot(new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(3), new BinaryTreeNode(4)), new BinaryTreeNode(5)));
        assert tree.getSize() == 5;
    }

    @Test
    @DisplayName("Teste - Criação da Árvore Binária sem")
    void isEmpty() {
        BinaryTree tree = new BinaryTree();
        assert tree.isEmpty();

        tree.setRoot(new BinaryTreeNode(1));
        assert !tree.isEmpty();

        tree.setRoot(null);
        assert tree.isEmpty();
    }

    @Test
    @DisplayName("Teste - Algortimo de PosOrder")
    void posOrder() {
        BinaryTree tree = new BinaryTree(new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(3), new BinaryTreeNode(4)), new BinaryTreeNode(5)));

        assert "3 4 2 5 1 ".equals(tree.posOrder());
        assert "3 4 2 ".equals(tree.posOrder(tree.getRoot().getLeft()));
    }

    @Test
    @DisplayName("Teste - Algortimo de PreOrder")
    void preOrder() {
        BinaryTree tree = new BinaryTree(new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(3), new BinaryTreeNode(4)), new BinaryTreeNode(5)));

        assert "1 2 3 4 5 ".equals(tree.preOrder());
        assert "2 3 4 ".equals(tree.preOrder(tree.getRoot().getLeft()));
    }

    @Test
    @DisplayName("Teste - Algortimo de InOrder")
    void inOrder() {
        BinaryTree tree = new BinaryTree(new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(3), new BinaryTreeNode(4)), new BinaryTreeNode(5)));

        assert "3 2 4 1 5 ".equals(tree.inOrder());
        assert "3 2 4 ".equals(tree.inOrder(tree.getRoot().getLeft()));
    }

}
