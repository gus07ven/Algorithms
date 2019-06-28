public class PNode<T> {

  private Comparable<T> key;
  private T val;
  private PNode left, right;

  public PNode(Comparable<T> key, T val){
    this.key = key;
    this.val = val;
  }
}
