public class HashTable<K, V> {
    private class HashNode<K, V> {
        K imp;
        V rant;
        final int hashCode;
        HashNode<K, V> next;

        public HashNode(K imp, V rant, HashNode <K, V> next, int hashCode) {
            this.imp = imp;
            this.rant = rant;
            this.next = next;
            this.hashCode = hashCode;
        }
    }

    private int getIndex(K imp) {
        int hashCode = imp.hashCode() % linkArr.length;
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


    public V get(K imp){
        int hashCode = getIndex(imp);

        for(HashNode<K,V> node = linkArr[hashCode]; node != null; node = node.next){
            if(imp.equals(node.imp))
                return node.rant;
        }
        return null;
    }

    public boolean delete(K imp){
        int hashCode = getIndex(imp);
        HashNode<K,V> previous = null;
        for(HashNode<K,V> node = linkArr[hashCode]; node != null; node = node.next){
            if((hashCode == node.hashCode) && imp.equals(node.imp)){
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

    public V put(K imp, V rant){
        int hashCode = getIndex(imp);
        for(HashNode<K,V> node = linkArr[hashCode]; node != null; node = node.next){
            if((hashCode == node.hashCode) && imp.equals(node.imp)){
                V oldrant = node.rant;
                node.rant = rant;
                return oldrant;
            }
        }
        HashNode<K,V> node = new HashNode<K,V>(imp, rant, linkArr[hashCode], hashCode);
        linkArr[hashCode] = node;

        return null;
    }

}
