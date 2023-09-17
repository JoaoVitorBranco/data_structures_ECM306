package tests.BinaryTree;

import main.BinaryTree.BinaryTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBinaryTreeNode {
    @Test
    @DisplayName("Teste - Criação do Nó da Árvore Binária com value")
    public void testBinaryTreeNodeValue() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        assert node.getValue() == 1;
        assert node.getLeft() == null;
        assert node.getRight() == null;

    }

    @Test
    @DisplayName("Teste - Criação do Nó da Árvore Binária sem value")
    public void testBinaryTreeNode() {
        BinaryTreeNode node = new BinaryTreeNode();
        assert node.getValue() == 0;
        assert node.getLeft() == null;
        assert node.getRight() == null;

    }

    @Test
    @DisplayName("Teste - Criação do Nó da Árvore Binária com value, left e right")
    public void testBinaryTreeNodeValueLeftRight() {
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assert node.getValue() == 1;
        assert node.getLeft().getValue() == 2;
        assert node.getRight().getValue() == 3;

    }

    @Test
    @DisplayName("Teste - Has Left")
    void hasLeft() {
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assert node.hasLeft();

        node.setLeft(null);
        assert !node.hasLeft();

        BinaryTreeNode node2 = new BinaryTreeNode(1);
        assert !node2.hasLeft();
    }

    @Test
    @DisplayName("Teste - Has Right")
    void hasRight() {
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assert node.hasRight();

        node.setRight(null);
        assert !node.hasRight();

        BinaryTreeNode node2 = new BinaryTreeNode(1);
        assert !node2.hasRight();
    }

    @Test
    @DisplayName("Teste - Is Leaf")
    void isLeaf() {
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assert !node.isLeaf();

        node.setLeft(null);
        node.setRight(null);
        assert node.isLeaf();

        BinaryTreeNode node2 = new BinaryTreeNode(1);
        assert node2.isLeaf();
    }

    @Test
    @DisplayName("Teste - Has One Child")
    void hasOneChild() {
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assert !node.hasOneChild();

        node.setLeft(null);
        assert node.hasOneChild();

        BinaryTreeNode node2 = new BinaryTreeNode(1);
        assert !node2.hasOneChild();
    }

    @Test
    @DisplayName("Teste - Has Two Children")
    void hasTwoChildren() {
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assert node.hasTwoChildren();

        node.setLeft(null);
        assert !node.hasTwoChildren();

        node.setLeft(new BinaryTreeNode(2));
        assert node.hasTwoChildren();
    }

    @Test
    @DisplayName("Teste - Has Children")
    void hasChildren() {
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assert node.hasChildren();

        node.setLeft(null);
        assert node.hasChildren();

        node.setLeft(new BinaryTreeNode(2));
        assert node.hasChildren();

        node.setLeft(null);
        node.setRight(null);
        assert !node.hasChildren();
    }

    @Test
    @DisplayName("Teste - To String")
    void testToString() {
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assert node.toString().equals("1");

        node.setLeft(null);
        assert node.toString().equals("1");

        node.setLeft(new BinaryTreeNode(2));
        assert node.toString().equals("1");

        node.setLeft(null);
        node.setRight(null);
        assert node.toString().equals("1");
    }
}
