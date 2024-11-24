public class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Node<?> other = (Node<?>) obj;
        return (data == null && other.data == null) || (data != null && data.equals(other.data));
    }

    @Override
    public int hashCode() {
        return (data != null) ? data.hashCode() : 0;
    }
}
