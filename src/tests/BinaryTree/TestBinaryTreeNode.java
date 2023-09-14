package tests.BinaryTree;

import main.BinaryTree.BinaryTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBinaryTreeNode {
    @Test
    @DisplayName("Teste - Criação do Nó da Árvore Binária com value")
    public void testBinaryTreeNodeValue() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        assert node.value == 1;
        assert node.left == null;
        assert node.right == null;

    }

    @Test
    @DisplayName("Teste - Criação do Nó da Árvore Binária sem value")
    public void testBinaryTreeNode() {
        BinaryTreeNode node = new BinaryTreeNode();
        assert node.value == 0;
        assert node.left == null;
        assert node.right == null;

    }

    @Test
    @DisplayName("Teste - Criação do Nó da Árvore Binária com value, left e right")
    public void testBinaryTreeNodeValueLeftRight() {
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assert node.value == 1;
        assert node.left.value == 2;
        assert node.right.value == 3;

    }


}
