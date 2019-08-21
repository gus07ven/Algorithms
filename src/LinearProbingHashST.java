public class LinearProbingHashST<Key, Value> {

  private int M = 3001;
  private Value[] vals = (Value[]) new Object[M];
  private Key[] keys = (Key[]) new Object[M];

  private int hash(Key key){
    return (key.hashCode() & 0x7fffffff) % M;
  }
}
