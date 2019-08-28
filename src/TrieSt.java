import java.util.LinkedList;
import java.util.Queue;

public class TrieSt<Value> {

  private static final int R = 256;   // Using extended ASCII
  private Node root = new Node();
  private int n = 0;

  private static class Node {
    private Object val;
    private Node[] next = new Node[R];
  }

  public int size(){
    return n;
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

  public Iterable<String> keys(){
    return keysWithPrefix("");
  }

  public Iterable<String> keysWithPrefix(String prefix){
    Queue<String> results = new LinkedList<>();
    Node x = get(root, prefix, 0);
    collect(x, new StringBuilder(prefix), results);
    return results;
  }

  private void collect(Node x, StringBuilder prefix, Queue<String> results){
    if(x == null) return;
    if(x.val != null) results.offer(prefix.toString());
    for(char c = 0; c < R; c++){
      prefix.append(c);
      collect(x.next[c], prefix, results);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }

  public void delete(String key){
    if(key == null) throw new IllegalArgumentException("Argument to delete is null");
    root = delete(root, key, 0);
  }

  private Node delete(Node x, String key, int d){
    if(x == null) return null;
    if(d == key.length()){
      if(x.val != null) n--;
      x.val = null;
    }
    else {
      char c = key.charAt(d);
      x.next[c] = delete(x.next[c], key, d + 1);
    }

    // remove subtrie rooted at x if it is completely empty
    if(x.val != null) return x;
    for(int c = 0; c < R; c++){
      if(x.next[c] != null) return x;
    }
    return null;
  }

  public static void main(String[] args) {
    String[] inputs = {"by", "sea", "sells", "shells", "shore", "the"};
    TrieSt<Integer> t = new TrieSt<>();
    t.put("by", 1);
    t.put("sea", 2);
    System.out.println(t.contains("sea"));
    System.out.println(t.get("sea"));
    System.out.println(t.contains("soon"));
    System.out.println(t.get("soon"));
    System.out.println(t.keys());
    t.delete("by");
    System.out.println(t.keys());
  }
}
