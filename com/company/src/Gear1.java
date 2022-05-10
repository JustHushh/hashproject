public class Gear1 <K extends Comparable<K>, V> {
    private Node root;
    int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        //code
    }
    public void get(K key){
        //code
    }
    public void delete(K key){
        //code
    }
    public void iterator(){
        //code
    }
}