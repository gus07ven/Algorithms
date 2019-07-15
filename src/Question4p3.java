
import java.util.ArrayList;
import java.util.LinkedList;

public class Question4p3 {

  public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
    LinkedList<TreeNode> current = new LinkedList<>();
    if (root != null) {
      current.add(root);
    }

    while (current.size() > 0) {
      result.add(current);
      LinkedList<TreeNode> parents = current;
      current = new LinkedList<>();
      for (TreeNode parent : parents) {
        // Visit the children
        if (parent.left != null) {
          current.add(parent.left);
        }
        if (parent.right != null) {
          current.add(parent.right);
        }
      }
    }
    return result;
  }

  public void createLevelLinkedListRecursive(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
    if (root == null) return;
    LinkedList<TreeNode> list = null;
    if (lists.size() == level) {
      // Level not contained in list
      list = new LinkedList<TreeNode>();
      lists.add(list);
    } else {
      list = lists.get(level);
    }
    list.add(root);
    createLevelLinkedListRecursive(root.left, lists, level + 1);
    createLevelLinkedListRecursive(root.right, lists, level + 1);
  }

  private ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
    createLevelLinkedListRecursive(root, lists, 0);
    return lists;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.insert(8);
    root.insert(12);
    root.insert(9);
    root.insert(13);
    ArrayList<LinkedList<TreeNode>> result = createLevelLinkedList(root);
  }
}
