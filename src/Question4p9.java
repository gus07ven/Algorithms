import java.util.ArrayList;
import java.util.LinkedList;

public class Question4p9 {

  public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
    ArrayList<LinkedList<Integer>> result = new ArrayList<>();

    if (node == null) {
      result.add(new LinkedList<Integer>());
      return result;
    }

    LinkedList<Integer> prefix = new LinkedList<Integer>();
    prefix.add(node.data);

    ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
    ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

    for (LinkedList<Integer> left : leftSeq) {
      for (LinkedList<Integer> right : rightSeq) {
        ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
        weaveLists(left, right, weaved, prefix);
        result.addAll(weaved);
      }
    }
    return result;
  }

  public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                                ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
    if (first.size() == 0 || second.size() == 0) {
      LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
      result.addAll(first);
      result.addAll(second);
      results.add(result);
      return;
    }

    int headFirst = first.removeFirst();
    prefix.addLast(headFirst);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    first.addFirst(headFirst);

    int headSecond = second.removeFirst();
    prefix.addLast(headSecond);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    second.addFirst(headSecond);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
//    root.left.left = new TreeNode(8);
//    root.left.right = new TreeNode(12);
//    root.right.left = new TreeNode(7);
//    root.right.right = new TreeNode(4);

    ArrayList<LinkedList<Integer>> result = allSequences(root);
    System.out.println(result);
  }
}
