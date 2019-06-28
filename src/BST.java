public class BST<K extends Comparable<K>, V> {

  private PNode root;

  private class PNode {

    private K key;
    private V val;
    private PNode left, right;
    private int size;

    public PNode(K key, V val, int size) {
      this.key = key;
      this.val = val;
      this.size = size;
    }
  }

  public BST() {
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size(root);
  }

  private int size(PNode x) {
    if (x == null) return 0;
    else return x.size;
  }

  // Return value corresponding to given key, or null if no such key.
  public V get(K key) {
    PNode x = root;
    while (x != null) {
      int cmp = key.compareTo(x.key);
      if (cmp < 0) x = x.left;
      else if (cmp > 0) x = x.right;
      else return x.val;
    }
    return null;
  }
}
