import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> testBST1;
    private BinarySearchTree<Integer> testBST2;
    private BinarySearchTree<Integer> testBST3;

    @Before
    public void setUp() {
        testBST1 = new BinarySearchTree<>();
        testBST1.insert(5);
        testBST1.insert(3);
        testBST1.insert(7);
        testBST1.insert(1);
        testBST1.insert(4);
        testBST1.insert(6);
        testBST1.insert(9);
        testBST1.insert(2);
        testBST1.insert(8);
        testBST1.insert(10);
        testBST2 = new BinarySearchTree<>();
        testBST3 = new BinarySearchTree<>();
        testBST3.insert(10);
        testBST3.insert(3);
        testBST3.insert(20);
        testBST3.insert(1);
        testBST3.insert(5);
        testBST3.insert(11);
        testBST3.insert(15);
        testBST3.insert(13);
        testBST3.insert(16);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(testBST1.isEmpty());
        assertTrue(testBST2.isEmpty());
        testBST2.insert(1);
        assertFalse(testBST2.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, testBST2.size());
        testBST2.insert(1);
        testBST2.insert(2);
        assertEquals(2, testBST2.size());
        testBST2.delete(1);
        assertEquals(1, testBST2.size());
        testBST2.delete(2);
        assertEquals(0, testBST2.size());
    }

    @Test
    public void testInsertAndTraverse() {
        testBST1.insert(4);
        testBST1.inorderTraverse(); // 1 2 3 4 4 5 6 7 8 9 10
        testBST1.preorderTraverse(); // 5 3 1 2 4 4 7 6 9 8 10
        testBST1.postorderTraverse(); // 2 1 4 4 3 6 8 10 9 7 5
    }

    @Test
    public void testDeleteAndTraverse() {
        testBST3.delete(1);
        testBST3.inorderTraverse(); // 3 5 10 11 13 15 16 20
        testBST3.delete(10);
        testBST3.inorderTraverse(); // 3 5 11 13 15 16 20
        testBST3.preorderTraverse(); // 11 3 5 20 15 13 16
        testBST3.delete(20);
        testBST3.preorderTraverse(); // 11 3 5 15 13 16
        try {
            testBST3.delete(241);
            fail("Should have raised an exception.");
        } catch (NoSuchElementException e) {
            assertEquals(3, testBST3.getHeight());
        }
    }

    @Test
    public void testGetHeight() {
        assertEquals(4 , testBST1.getHeight());
        assertEquals(0, testBST2.getHeight());
        testBST2.insert(1);
        assertEquals(1, testBST2.getHeight());
        for (int i = 2; i <= 5; i++) {
            testBST2.insert(i);
        }
        assertEquals(5, testBST2.getHeight());
    }

    @Test
    public void testContains() {
        assertFalse(testBST1.contains(11));
        assertTrue(testBST1.contains(3));
    }

    @Test
    public void testRetrieve() {
        try {
            testBST1.retrieve(11);
            fail("Should have raised an exception.");
        } catch (NoSuchElementException e) {
            assertEquals(new Integer(2), testBST1.retrieve(2));
        }
    }

}
