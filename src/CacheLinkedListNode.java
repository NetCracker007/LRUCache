public class CacheLinkedListNode<T> {
    T value;
    CacheLinkedListNode<T> prev;
    CacheLinkedListNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CacheLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(CacheLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public CacheLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(CacheLinkedListNode<T> next) {
        this.next = next;
    }
}

