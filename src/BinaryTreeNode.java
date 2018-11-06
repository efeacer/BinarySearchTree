public class BinaryTreeNode<T extends Comparable<T>> {

    private T item;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T item) {
        this.item = item;
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeNode(T item, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.item = item;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getItem() {
        return item;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

}
