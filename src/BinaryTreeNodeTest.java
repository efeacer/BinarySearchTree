import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class BinaryTreeNodeTest {

    private BinaryTreeNode<Integer> testNode1;
    private BinaryTreeNode<Integer> testNode2;

    @Before
    public void setUp() {
        testNode1 = new BinaryTreeNode<Integer>(1);
        testNode2 = new BinaryTreeNode<Integer>(2,
                new BinaryTreeNode<>(1),
                new BinaryTreeNode<>(3));
    }

    @Test
    public void testGetItem() {
        assertEquals(new Integer(1), testNode1.getItem());
        assertEquals(new Integer(2), testNode2.getItem());
    }

    @Test
    public void testGetLeftChild() {
        assertNull(testNode1.getLeftChild());
        assertNotNull(testNode2.getLeftChild());
        assertEquals(new Integer(1), testNode2.getLeftChild().getItem());
    }

    @Test
    public void testGetRightChild() {
        assertNull(testNode1.getRightChild());
        assertNotNull(testNode2.getRightChild());
        assertEquals(new Integer(3), testNode2.getRightChild().getItem());
    }

    @Test
    public void testSetItem() {
        testNode1.setItem(5);
        assertEquals(new Integer(5), testNode1.getItem());
    }

    @Test
    public void testSetLeftChild() {
        assertNull(testNode1.getLeftChild());
        testNode1.setLeftChild(new BinaryTreeNode<Integer>(10));
        assertNotNull(testNode1.getLeftChild());
        assertEquals(new Integer(10), testNode1.getLeftChild().getItem());
    }

    @Test
    public void testSetRightChild() {
        assertNull(testNode1.getRightChild());
        testNode1.setRightChild(new BinaryTreeNode<Integer>(10));
        assertNotNull(testNode1.getRightChild());
        assertEquals(new Integer(10), testNode1.getRightChild().getItem());
    }

}
