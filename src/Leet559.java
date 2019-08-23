import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet559 {

  private class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public static int maxDepth(Node root) {
    if (root == null) return 0;

    int depth = 0;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node current = queue.poll();
        for (Node child : current.children) {
          queue.offer(child);
        }
      }
      depth++;
    }
    return depth;
  }

  public static int maxDepthOptimized(Node root) {
    if (root == null) return 0;
    int max = 0;
    for (int i = 0; i < root.children.size(); i++) {
      int getMax = maxDepth(root.children.get(i));
      if (getMax > max) {
        max = getMax;
      }
    }
    return max + 1;
  }
}

