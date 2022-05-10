public class HashNode<K, V> {
    private K imp;
    private V rant;
    private HashNode<K, V> next;

    public HashNode(K imp, V rant){
        this.imp = imp;
        this.rant = rant;
    }

    @Override
    public String toString() {
        return "{" + imp + " " + rant + "}";
    }
}