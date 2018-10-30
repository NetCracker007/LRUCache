public class CacheLinkedList<T> {
    CacheLinkedListNode<T> head;
    CacheLinkedListNode<T> tail;
    int size;

    public int getSize() {
        return size;
    }

    public CacheLinkedListNode<T> getHead() {
        return head;
    }

    public void setHead(CacheLinkedListNode<T> head) {
        this.head = head;
    }

    public CacheLinkedListNode<T> getTail() {
        return tail;
    }

    public void setTail(CacheLinkedListNode<T> tail) {
        this.tail = tail;
    }

    public void addToHead(CacheLinkedListNode<T> node)
    {
        if (head == null)
        {
            head = node;
            tail = node;
            node.setNext(null);
            node.setPrev(null);
        }
        else {
            node.setNext(head);
            node.setPrev(null);
            head.setPrev(node);
            head = node;
        }
        size += 1;
    }

    public void moveToHead(CacheLinkedListNode<T> node)
    {
        if (head != node)
        {
            if (tail == node)
            {
                tail = node.getPrev();
            }
            node.getPrev().setNext(node.getNext());
            if (node.getNext() != null)
            {
                node.getNext().setPrev(node.getPrev());
            }
            node.setPrev(null);
            node.setNext(null);
            size -= 1;
            addToHead(node);
        }
    }

    public void removeTail()
    {
        if (tail != null)
        {
            if (tail.getPrev() != null)
            {
                CacheLinkedListNode<T> prevTail = tail;
                tail = prevTail.getPrev();
                tail.setNext(null);
                prevTail.setPrev((null));
            }
            size -= 1;
        }
    }
}
