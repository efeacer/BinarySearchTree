public interface BinarySearchTreeInterface<T extends Comparable<T>> {

    public boolean isEmpty();

    public int size();

    public boolean contains(T item);

    public T retrieve(T item);

    public T delete(T item);

    public void insert(T item);

    public void inorderTraverse();

    public void preorderTraverse();

    public void postorderTraverse();

}
