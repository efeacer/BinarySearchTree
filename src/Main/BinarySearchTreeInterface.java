package Main;

public interface BinarySearchTreeInterface<T extends Comparable<T>> {

    boolean isEmpty();

    int size();

    int getHeight();

    boolean contains(T item);

    T retrieve(T item);

    void delete(T item);

    void insert(T item);

    void inorderTraverse();

    void preorderTraverse();

    void postorderTraverse();

}
