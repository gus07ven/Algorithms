import java.util.NoSuchElementException;

public class BST<K extends Comparable<K>, V> {

  private PNode root;

  private class PNode {

    private K key;
    private V val;
    private int size;
    private PNode left, right;

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
  // Best O(log N), worse (N)
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

  public void put(K key, V val){
    if(key == null) throw new IllegalArgumentException("calls put() with a null key");
    if(val == null){
      delete(key);
      return;
    }
    root = put(root, key, val);
  }

  // Best O(log N). Worse O(n)
  private PNode put(PNode x, K key, V val){
    if(x == null) return new PNode(key, val, 1);
    int cmp = key.compareTo(x.key);
    if(cmp < 0){
      x.left = put(x.left, key, val);
    } else if(cmp > 0){
      x.right = put(x.right, key, val);
    } else {
      x.val = val;
    }
    return x;
  }

  public K min() {
    if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
    return min(root).key;
  }

  private PNode min(PNode x) {
    if (x.left == null) return x;
    else                return min(x.left);
  }

  public void deleteMin() {
    if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
    root = deleteMin(root);
  }

  private PNode deleteMin(PNode x) {
    if (x.left == null) return x.right;
    x.left = deleteMin(x.left);
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }

  // Hibbard deletion. If we allow delete, every operation degenerates to square root of n.
  // Only a Red-Black Binary Search Tree will guarantee logarithmic performance for all operations.
  public void delete(K key){
    root = delete(root, key);
  }

  private PNode delete(PNode x, K key){
    if(x == null) return null;
    int cmp = key.compareTo(x.key);
    if(cmp < 0) x.left = delete(x.left, key);
    else if(cmp > 0) x.right = delete(x.right, key);
    else {
      if(x.right == null) return x.left;
      if(x.left == null) return x.right;

      PNode t = x;
      x = min(t.right);
      x.right = deleteMin(x.left);
      x.left = t.left;
    }
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }
}
