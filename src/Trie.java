import java.util.ArrayList;

public class Trie {

  private TrieNode root;

  public Trie(ArrayList<String> list){
    root = new TrieNode();
    for(String word : list){
      root.addWord(word);
    }
  }

  public Trie(String[] list){
    root = new TrieNode();
    for(String word : list){
      root.addWord(word);
    }
  }

  private boolean contains(String prefix, boolean exact){
    TrieNode lastNode = root;
    int i = 0;
    for(i = 0; i < prefix.length(); i++){
      lastNode = lastNode.getChild(prefix.charAt(i));
      if(lastNode == null){
        return false;
      }
    }
    return !exact || lastNode.terminates();
  }

  public boolean contains(String prefix){
    return contains(prefix, false);
  }

  public TrieNode getRoot(){
    return root;
  }

  public static void main(String[] args) {

    ArrayList<String> list = new ArrayList<>();
    list.add("hello");
    list.add("car");
    list.add("hi");
    list.add("cat");
    list.add("fly");

    Trie t = new Trie(list);
    System.out.println(t.contains("heaven"));
    System.out.println(t.contains("car"));
  }
}
