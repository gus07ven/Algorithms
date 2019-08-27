import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet429 {

  private static class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

    public static List<List<Integer>> levelOrder(Node root) {
      return getLevelOrderTraversal(root, new ArrayList<>(), 0);
    }

    public static List<List<Integer>> getLevelOrderTraversal(Node root, List<List<Integer>> levels, int level){
      if(root == null) return levels;

      if(level >= levels.size()) levels.add(level, new ArrayList<>());

      List<Integer> curLevel = levels.get(level);
      curLevel.add(root.val);
      if(root.children != null){
        for(Node child : root.children){
          getLevelOrderTraversal(child, levels, level + 1);
        }
      } else {
        return levels;
      }
      return levels;
    }

    public static List<List<Integer>> levelOrderBFS(Node root){
      List<List<Integer>> ret = new LinkedList<>();

      if (root == null) return ret;

      Queue<Node> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
        List<Integer> curLevel = new LinkedList<>();
        int len = queue.size();
        for (int i = 0; i < len; i++) {
          Node curr = queue.poll();
          curLevel.add(curr.val);
          if(curr.children != null){
            for (Node c : curr.children)
              queue.offer(c);
          }
        }
        ret.add(curLevel);
      }
      return ret;
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

    System.out.println();
    System.out.println("DFS results: ");
    List<List<Integer>> result = levelOrder(root);
    for(List<Integer> level : result){
      System.out.println();
      for(Integer i : level){
        System.out.print(i);
      }
    }

    System.out.println();
    System.out.println();
    System.out.println("BFS results: ");
    List<List<Integer>> resultBFS = levelOrderBFS(root);
    for(List<Integer> level : resultBFS){
      System.out.println();
      for(Integer i : level){
        System.out.print(i);
      }
    }

    System.out.println("In this case, DFS is faster than BFS.");
  }
}
