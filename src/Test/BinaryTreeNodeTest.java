package Test;

import Main.BinaryTreeNode;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeNodeTest {

    private BinaryTreeNode<Integer> testNode1;
    private BinaryTreeNode<Integer> testNode2;

    @Before
    public void setUp() {
        testNode1 = new BinaryTreeNode<>(1);
        testNode2 = new BinaryTreeNode<>(2,
                new BinaryTreeNode<>(1),
                new BinaryTreeNode<>(3));
    }

    @Test
    public void testGetItem() {
        Assert.assertEquals(new Integer(1), testNode1.getItem());
        Assert.assertEquals(new Integer(2), testNode2.getItem());
    }

    @Test
    public void testGetLeftChild() {
        assertNull(testNode1.getLeftChild());
        assertNotNull(testNode2.getLeftChild());
        Assert.assertEquals(new Integer(1), testNode2.getLeftChild().getItem());
    }

    @Test
    public void testGetRightChild() {
        assertNull(testNode1.getRightChild());
        assertNotNull(testNode2.getRightChild());
        Assert.assertEquals(new Integer(3), testNode2.getRightChild().getItem());
    }

    @Test
    public void testSetItem() {
        testNode1.setItem(5);
        Assert.assertEquals(new Integer(5), testNode1.getItem());
    }

    @Test
    public void testSetLeftChild() {
        TestCase.assertNull(testNode1.getLeftChild());
        testNode1.setLeftChild(new BinaryTreeNode<>(10));
        TestCase.assertNotNull(testNode1.getLeftChild());
        Assert.assertEquals(new Integer(10), testNode1.getLeftChild().getItem());
    }

    @Test
    public void testSetRightChild() {
        TestCase.assertNull(testNode1.getRightChild());
        testNode1.setRightChild(new BinaryTreeNode<>(10));
        TestCase.assertNotNull(testNode1.getRightChild());
        Assert.assertEquals(new Integer(10), testNode1.getRightChild().getItem());
    }

    @Test
    public void testIsLeaf() {
        assertTrue(testNode1.isLeaf());
        assertFalse(testNode2.isLeaf());
    }

}
