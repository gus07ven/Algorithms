public class TrieSt<Value> {

  private static final int R = 256;   // Using extended ASCII
  private Node root = new Node();

  private static class Node {
    private Object val;
    private Node[] next = new Node[R];
  }

  public void put(String key, Value val){
    root = put(root, key, val, 0);
  }

  private Node put(Node x, String key, Value val, int d){
    if(x == null) x = new Node();
    if(d == key.length()) {
      x.val = val;
      return x;
    }
    char c = key.charAt(d);
    x.next[c] = put(x.next[c], key, val, d + 1);
    return x;
  }

  public boolean contains(String key){
    return get(key) != null;
  }

  public Value get(String key){
    Node x = get(root, key, 0);
    if(x == null) return null;
    return (Value) x.val;
  }

  private Node get(Node x, String key, int d){
    if(x == null) return null;
    if(d == key.length()) return x;
    char c = key.charAt(d);
    return get(x.next[c], key, d + 1);
  }

  public static void main(String[] args) {
    String[] inputs = {"by", "sea", "sells", "shells", "shore", "the"};
    TrieSt<Integer> t = new TrieSt<>();
    t.put("by", 1);
    t.put("sea", 2);
    t.put("sells", 3);
    t.put("shells", 4);
    t.put("shore", 5);
    t.put("the", 6);
    System.out.println(t.contains("sea"));
    System.out.println(t.get("sea"));
    System.out.println(t.contains("soon"));
    System.out.println(t.get("soon"));
  }
}
