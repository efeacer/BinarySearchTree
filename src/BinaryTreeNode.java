class BinaryTreeNode<T extends Comparable<T>> {

    private T item;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    BinaryTreeNode(T item) {
        this.item = item;
        leftChild = null;
        rightChild = null;
    }

    BinaryTreeNode(T item, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        this.item = item;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    T getItem() {
        return item;
    }

    BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    void setItem(T item) {
        this.item = item;
    }

    void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

}
