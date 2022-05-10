public class HashTable<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;
        final int hashCode;
        HashNode<K, V> next;

        public HashNode(K key, V value, HashNode <K, V> next, int hashCode) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hashCode = hashCode;
        }
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode() % linkArr.length;
        if (hashCode < 0) {
            hashCode += linkArr.length;
        }
        return hashCode;
    }

    private HashNode<K, V>[] linkArr;
    private int M = 11;
    private int size;
    public HashTable(int M) {
        linkArr = new HashNode[M];
    }


    public V take(K key){
        int hashCode = getIndex(key);

        for(HashNode<K,V> node = linkArr[hashCode]; node != null; node = node.next){
            if(key.equals(node.key))
                return node.value;
        }
        return null;
    }

    public boolean delete(K key){
        int hashCode = getIndex(key);
        HashNode<K,V> previous = null;
        for(HashNode<K,V> node = linkArr[hashCode]; node != null; node = node.next){
            if((hashCode == node.hashCode) && key.equals(node.key)){
                if(previous != null){
                    previous.next = node.next;
                }else{
                    linkArr[hashCode] = node.next;
                }
                return true;
            }
            previous = node;
        }
        return false;
    }

    public V pdown(K key, V value){
        int hashCode = getIndex(key);
        for(HashNode<K,V> node = linkArr[hashCode]; node != null; node = node.next){
            if((hashCode == node.hashCode) && key.equals(node.key)){
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        HashNode<K,V> node = new HashNode<K,V>(key, value, linkArr[hashCode], hashCode);
        linkArr[hashCode] = node;

        return null;
    }

}
