package CustomMap;

import java.util.Objects;

public class CustomHashMap<K, V> {

    private static final int INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int TREEIFY_THRESHOLD = 8;

    private Node<K, V>[] hashTable;

    private transient int tableSize = 0;
    private transient int threshold = 0;

    @SuppressWarnings("unchecked")
    CustomHashMap() {
        tableSize = INITIAL_CAPACITY;
        hashTable = (Node<K, V>[]) new Node[INITIAL_CAPACITY];
        threshold = (int) (INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    CustomHashMap(int capacity) {
        tableSize = tableSizeFor(capacity - 1);
        hashTable = (Node<K, V>[]) new Node[tableSize];
        threshold = (int) (tableSize * DEFAULT_LOAD_FACTOR);
    }

    private int tableSizeFor(int cap) {
        int n = -1 >>> numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static int numberOfLeadingZeros(int i) {
        if (i <= 0)
            return i == 0 ? 32 : 0;
        int n = 31;
        if (i >= 1 << 16) {
            n -= 16;
            i >>>= 16;
        }
        if (i >= 1 << 8) {
            n -= 8;
            i >>>= 8;
        }
        if (i >= 1 << 4) {
            n -= 4;
            i >>>= 4;
        }
        if (i >= 1 << 2) {
            n -= 2;
            i >>>= 2;
        }
        return n - (i >>> 1);
    }

    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public V get(K key) {
        int index = hash(key) & (tableSize - 1);
        Node<K, V> node = hashTable[index];

        while (node != null) {
            if (node.getKey() == key) {
                return node.getValue();
            }
            node = node.getNext();
        }

        return null;
    }

    private void put(K key, V value) {
        int index = hash(key) & (tableSize - 1);
        Node<K, V> node = hashTable[index];

        if (node == null) {
            tableSize++;
            hashTable[index] = new Node<>(key, value);
            return;
        }

        Node<K, V> prevNode = node;

        while (node != null) {
            if (node.getKey() == key) {
                node.setValue(value);
                return;
            }
            prevNode = node;
            node = node.getNext();
        }

        tableSize++;
        prevNode.setNext(new Node<>(key, value));

        if (tableSize >= threshold) {
            resize();
        }
    }

    public V remove(K key) {
        int index = hash(key) & (hashTable.length - 1);
        Node<K, V> node = hashTable[index];
        Node<K, V> prev = null;
        while (node != null) {
            if (Objects.equals(node.getKey(), key)) {
                if (prev == null) {
                    hashTable[index] = node.getNext();
                } else {
                    prev.setNext(node.getNext());
                }
                tableSize--;
                return node.getValue();
            }
            prev = node;
            node = node.getNext();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = hashTable.length * 2;
        if (newCapacity > MAXIMUM_CAPACITY) {
            return;
        }
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCapacity];
        for (Node<K, V> node : hashTable) {
            while (node != null) {
                int newIndex = hash(node.getKey()) & (newCapacity - 1);
                Node<K, V> next = node.getNext();
                node.setNext(newTable[newIndex]);
                newTable[newIndex] = node;
                node = next;
            }
        }
        hashTable = newTable;
        threshold = (int) (newCapacity * DEFAULT_LOAD_FACTOR);
    }

    public int getSize() {
        return this.tableSize;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node<?, ?> node)) return false;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
