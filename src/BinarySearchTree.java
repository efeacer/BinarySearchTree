import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeInterface<T> {

    private BinaryTreeNode<T> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getHeight() {
        return getHeightHelper(root);
    }

    private int getHeightHelper(BinaryTreeNode<T> treeRoot) {
        if (treeRoot == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeightHelper(treeRoot.getLeftChild()),
                    getHeightHelper(treeRoot.getRightChild()));
        }
    }

    @Override
    public boolean contains(T item) {
        return containsHelper(root, item);
    }

    private boolean containsHelper(BinaryTreeNode<T> treeRoot, T item) {
        if (treeRoot == null) {
            return false;
        } else if (item.compareTo(treeRoot.getItem()) == 0) {
            return true;
        } else if (item.compareTo(treeRoot.getItem()) < 0) {
            return containsHelper(treeRoot.getLeftChild(), item);
        } else {
            return containsHelper(treeRoot.getRightChild(), item);
        }
    }

    @Override
    public T retrieve(T item) throws NoSuchElementException {
        T retrievedItem = retrieveHelper(root, item);
        if (retrievedItem == null) {
            throw new NoSuchElementException();
        } else {
            return retrievedItem;
        }
    }

    private T retrieveHelper(BinaryTreeNode<T> treeRoot, T item) {
        if (treeRoot == null) {
            return null;
        } else if (item.compareTo(treeRoot.getItem()) == 0) {
            return treeRoot.getItem();
        } else if (item.compareTo(treeRoot.getItem()) < 0) {
            return retrieveHelper(treeRoot.getLeftChild(), item);
        } else {
            return retrieveHelper(treeRoot.getRightChild(), item);
        }
    }

    @Override
    public void delete(T item) throws NoSuchElementException {
        root = deleteHelper(root, item);
        size--;
    }

    private BinaryTreeNode<T> deleteHelper(BinaryTreeNode<T> treeRoot, T item) throws NoSuchElementException {
        if (treeRoot == null) {
            throw new NoSuchElementException();
        } else if (item.compareTo(treeRoot.getItem()) == 0) {
            if (treeRoot.isLeaf()) {
                return null;
            } else if (treeRoot.getLeftChild() == null) {
                return treeRoot.getRightChild();
            } else if (treeRoot.getRightChild() == null) {
                return treeRoot.getLeftChild();
            } else {
                BinaryTreeNode<T> inorderSuccessor = getInorderSuccessor(treeRoot);
                treeRoot.setItem(inorderSuccessor.getItem());
                treeRoot.setRightChild(deleteHelper(treeRoot.getRightChild(), inorderSuccessor.getItem()));
            }
        } else if (item.compareTo(treeRoot.getItem()) < 0) {
            treeRoot.setLeftChild(deleteHelper(treeRoot.getLeftChild(), item));
        } else {
            treeRoot.setRightChild(deleteHelper(treeRoot.getRightChild(), item));
        }
        return treeRoot;
    }

    private BinaryTreeNode<T> getInorderSuccessor(BinaryTreeNode<T> treeRoot) {
        BinaryTreeNode<T> inorderSuccessor = treeRoot.getRightChild();
        while (inorderSuccessor.getLeftChild() != null) {
            inorderSuccessor = inorderSuccessor.getLeftChild();
        }
        return inorderSuccessor;
    }

    @Override
    public void insert(T item) {
        if (root == null) {
            root = new BinaryTreeNode<T>(item);
        } else {
            insertHelper(root, item);
        }
        size++;
    }

    private void insertHelper(BinaryTreeNode<T> treeRoot, T item) {
        if (item.compareTo(treeRoot.getItem()) <= 0) {
            if (treeRoot.getLeftChild() == null) {
                treeRoot.setLeftChild(new BinaryTreeNode<T>(item));
            } else {
                insertHelper(treeRoot.getLeftChild(), item);
            }
        } else {
            if (treeRoot.getRightChild() == null) {
                treeRoot.setRightChild(new BinaryTreeNode<T>(item));
            } else {
                insertHelper(treeRoot.getRightChild(), item);
            }
        }
    }

    @Override
    public void inorderTraverse() {
        System.out.print("\nInorder traversal of the BST: \n- ");
        inorderTraverseHelper(root);
        System.out.println("-");
    }

    private void inorderTraverseHelper(BinaryTreeNode<T> treeRoot) {
        if (treeRoot != null) {
            inorderTraverseHelper(treeRoot.getLeftChild());
            System.out.print(treeRoot.getItem() + " ");
            inorderTraverseHelper(treeRoot.getRightChild());
        }
    }

    @Override
    public void preorderTraverse() {
        System.out.print("\nPreorder traversal of the BST: \n- ");
        preorderTraverseHelper(root);
        System.out.println("-");
    }

    private void preorderTraverseHelper(BinaryTreeNode<T> treeRoot) {
        if (treeRoot != null) {
            System.out.print(treeRoot.getItem() + " ");
            preorderTraverseHelper(treeRoot.getLeftChild());
            preorderTraverseHelper(treeRoot.getRightChild());
        }
    }

    @Override
    public void postorderTraverse() {
        System.out.print("\nPostorder traversal of the BST: \n- ");
        postorderTraverseHelper(root);
        System.out.println("-");
    }

    private void postorderTraverseHelper(BinaryTreeNode<T> treeRoot) {
        if (treeRoot != null) {
            postorderTraverseHelper(treeRoot.getLeftChild());
            postorderTraverseHelper(treeRoot.getRightChild());
            System.out.print(treeRoot.getItem() + " ");
        }
    }

}
