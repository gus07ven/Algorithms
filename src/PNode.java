public class PNode<K, V> {

  private Comparable<K> key;
  private V val;
  private PNode left, right;
  int size;

  public PNode(Comparable<K> key, V val, int size){
    this.key = key;
    this.val = val;
    this.size = size;
  }
}
