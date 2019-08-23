import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet559 {

  private class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
