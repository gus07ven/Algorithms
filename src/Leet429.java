import java.util.ArrayList;
import java.util.List;

public class Leet429 {

  private static class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }


  }

  public static void main(String[] args) {
    List<Node> rootChildren = new ArrayList<>();
    List<Node> child1Children = new ArrayList<>();
    Node c1c1 = new Node();
    c1c1.val = 5;
    child1Children.add(c1c1);
    Node c1c2 = new Node();
    c1c2.val = 6;
    child1Children.add(c1c2);
    Node child1 = new Node();
    child1.val = 3;
    child1.children = child1Children;
    rootChildren.add(child1);

    Node child2 = new Node();
    child2.val = 2;
    rootChildren.add(child2);
    Node child3 = new Node();
    child3.val = 4;
    rootChildren.add(child3);
    Node root = new Node(1, rootChildren);

  }
}
