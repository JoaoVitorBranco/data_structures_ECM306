package tests;

import main.BinaryTree.BinaryTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBinaryTreeNode {
    @Test
    @DisplayName("Teste - Criação do Nó da Árvore Binária com value")
    public void testBinaryTreeNodeValue() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1);
        assert node.getValue() == 1;
        assert node.getLeft() == null;
        assert node.getRight() == null;

    }

    @Test
    @DisplayName("Teste - Criação do Nó da Árvore Binária sem value")
    public void testBinaryTreeNode() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>();
        assert node.getLeft() == null;
        assert node.getRight() == null;

    }

    @Test
    @DisplayName("Teste - Criação do Nó da Árvore Binária com value, left e right")
    public void testBinaryTreeNodeValueLeftRight() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3));
        assert node.getValue() == 1;
        assert node.getLeft().getValue() == 2;
        assert node.getRight().getValue() == 3;

    }

    @Test
    @DisplayName("Teste - Add")
    public void testBinaryTreeNodeAdd(){
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1);
        node.add(2);
        assert node.getLeft().getValue() == 2;
        node.add(3);
        assert node.getRight().getValue() == 3;
        node.add(4);
        assert node.getLeft().getLeft().getValue() == 4;
        node.add(5);
        assert node.getLeft().getRight().getValue() == 5;
        node.add(6);
    }

    @Test
    @DisplayName("Teste - Has Left")
    void hasLeft() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3));
        assert node.hasLeft();

        node.setLeft(null);
        assert !node.hasLeft();

        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(1);
        assert !node2.hasLeft();
    }

    @Test
    @DisplayName("Teste - Has Right")
    void hasRight() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3));
        assert node.hasRight();

        node.setRight(null);
        assert !node.hasRight();

        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(1);
        assert !node2.hasRight();
    }

    @Test
    @DisplayName("Teste - Is Leaf")
    void isLeaf() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3));
        assert !node.isLeaf();

        node.setLeft(null);
        node.setRight(null);
        assert node.isLeaf();

        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(1);
        assert node2.isLeaf();
    }

    @Test
    @DisplayName("Teste - Has One Child")
    void hasOneChild() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3));
        assert !node.hasOneChild();

        node.setLeft(null);
        assert node.hasOneChild();

        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(1);
        assert !node2.hasOneChild();
    }

    @Test
    @DisplayName("Teste - Has Two Children")
    void hasTwoChildren() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3));
        assert node.hasTwoChildren();

        node.setLeft(null);
        assert !node.hasTwoChildren();

        node.setLeft(new BinaryTreeNode<Integer>(2));
        assert node.hasTwoChildren();
    }

    @Test
    @DisplayName("Teste - Has Children")
    void hasChildren() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3));
        assert node.hasChildren();

        node.setLeft(null);
        assert node.hasChildren();

        node.setLeft(new BinaryTreeNode<Integer>(2));
        assert node.hasChildren();

        node.setLeft(null);
        node.setRight(null);
        assert !node.hasChildren();
    }

    @Test
    @DisplayName("Teste - To String")
    void testToString() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3));
        assert node.toString().equals("1");

        node.setLeft(null);
        assert node.toString().equals("1");

        node.setLeft(new BinaryTreeNode<Integer>(2));
        assert node.toString().equals("1");

        node.setLeft(null);
        node.setRight(null);
        assert node.toString().equals("1");
    }
}
