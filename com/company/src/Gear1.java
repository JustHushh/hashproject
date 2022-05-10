import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.*;

public class Gear1<K extends Comparable<K>, V>{
    private Node root;
    private class Node {
        private K imp;
        private V rant;
        private Node side, oside;
        private int N;

        public Node(K imp, V rant, int N) {
            this.imp = imp;
            this.rant = rant;
            this.N = N;
        }
    }

    private Node min(Node x) {
        if (x.side == null) return x;
        else                return min(x.side);
    }

    public K max() {
        if (isEmpty()) return null;
        return max(root).imp;
    }

    public K min() {
        if (isEmpty()) return null;
        return min(root).imp;
    }

    public void put(K imp, V rant) {
        if (rant == null) { delete(imp); return; }
        root = put(root, imp, rant);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private Node max(Node x) {
        if (x.oside == null) return x;
        else                 return max(x.oside);
    }
    public int size() {
        return size(root);
    }

    public V get(K imp) {
        return get(root, imp);
    }
    private V get(Node x, K imp) {
        if (x == null) return null;
        int cmp = imp.compareTo(x.imp);
        if      (cmp < 0) return get(x.side, imp);
        else if (cmp > 0) return get(x.oside, imp);
        else              return x.rant;
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    private Node put(Node x, K imp, V rant) {
        if (x == null) return new Node(imp, rant, 1);
        int cmp = imp.compareTo(x.imp);
        if      (cmp < 0) x.side  = put(x.side,  imp, rant);
        else if (cmp > 0) x.oside = put(x.oside, imp, rant);
        else              x.rant   = rant;
        x.N = 1 + size(x.side) + size(x.oside);
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) throw new RuntimeException("underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.side == null) return x.oside;
        x.side = deleteMin(x.side);
        x.N = size(x.side) + size(x.oside) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new RuntimeException("underflow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.oside == null) return x.side;
        x.oside = deleteMax(x.oside);
        x.N = size(x.side) + size(x.oside) + 1;
        return x;
    }
    public void delete(K imp) {
        root = delete(root, imp);
    }

    private Node delete(Node x, K imp) {
        if (x == null) return null;
        int cmp = imp.compareTo(x.imp);
        if      (cmp < 0) x.side  = delete(x.side,  imp);
        else if (cmp > 0) x.oside = delete(x.oside, imp);
        else {
            if (x.oside == null) return x.side;
            if (x.side  == null) return x.oside;
            Node t = x;
            x = min(t.oside);
            x.oside = deleteMin(t.oside);
            x.side = t.side;
        }
        x.N = size(x.side) + size(x.oside) + 1;
        return x;
    }
    public Iterable<K> imps() {
        return imps(min(), max());
    }

    public Iterable<K> imps(K lo, K hi) {
        Queue<K> queue = new Queue<K>() {
            public int size() {
                return 0;
            }

            public boolean isEmpty() {
                return false;
            }

            public boolean contains(Object o) {
                return false;
            }

            public Iterator<K> iterator() {
                return null;
            }

            public Object[] toArray() {
                return new Object[0];
            }

            public <T> T[] toArray(T[] a) {
                return null;
            }

            public boolean add(K k) {
                return false;
            }

            public boolean remove(Object o) {
                return false;
            }

            public boolean containsAll(Collection<?> c) {
                return false;
            }

            public boolean addAll(Collection<? extends K> c) {
                return false;
            }

            public boolean removeAll(Collection<?> c) {
                return false;
            }

            public boolean retainAll(Collection<?> c) {
                return false;
            }

            public void clear() {

            }

            public boolean equals(Object o) {
                return false;
            }

            public int hashCode() {
                return 0;
            }

            public boolean offer(K k) {
                return false;
            }

            public K remove() {
                return null;
            }

            public K poll() {
                return null;
            }

            public K element() {
                return null;
            }

            public K peek() {
                return null;
            }
        };
        return queue;
    }

}