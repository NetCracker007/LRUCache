import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {

    private static final int DEFAULT_CACHE_SIZE = 10;
    CacheLinkedList<T> cacheLinkedList;
    Map<Integer, CacheLinkedListNode<T>> cacheMap;
    int maxSize;

    public LRUCache() {
        cacheMap = new HashMap<>();
        cacheLinkedList =  new CacheLinkedList<>();
        this.maxSize = DEFAULT_CACHE_SIZE;
    }

    public LRUCache(int size) {
        cacheMap = new HashMap<>();
        cacheLinkedList =  new CacheLinkedList<>();
        this.maxSize = size;
    }

    public T fetchCacheObject(int key)
    {
        T value = null;
        if (cacheMap.containsKey(key))
        {
            CacheLinkedListNode<T> cacheNode = cacheMap.get(key);
            if (cacheNode != null) {
                synchronized (cacheLinkedList)
                {
                    cacheLinkedList.moveToHead(cacheNode);
                }
                value = cacheNode.getValue();
            }
        }
        return value;
    }

    public void insert(T val)
    {
        if (val != null)
        {
            CacheLinkedListNode<T> node = new CacheLinkedListNode<T>(){{
                setPrev(null);
                setNext(null);
                setValue(val);
            }};
            synchronized (cacheLinkedList)
            {
                if (cacheLinkedList.getSize() == maxSize)
                {

                    cacheLinkedList.removeTail();
                }
                cacheLinkedList.addToHead(node);
            }
            cacheMap.put(val.hashCode(), node);
        }
    }

}
