public class SeparateChainingHashST<Key, Value> {

  private int M = 97;       // number of chains
  private Node[] st = new Node[M];   // array of chains

  private static class Node {

    private Object key;
    private Object val;
    private Node next;
  }

  private int hash(Key key){
    return (key.hashCode() & 0x7fffffff) % M;
  }

}
