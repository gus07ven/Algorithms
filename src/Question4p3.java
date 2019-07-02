
import java.util.ArrayList;
import java.util.LinkedList;

public class Question4p3 {

  public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
    LinkedList<TreeNode> current = new LinkedList<>();
    if(root != null){
      current.add(root);
    }

    while(current.size() > 0){
      result.add(current);
      LinkedList<TreeNode> parents = current;
      current = new LinkedList<>();
      for(TreeNode parent : parents){
        // Visit the children
        if(parent.left != null){
          current.add(parent.left);
        }
        if(parent.right != null){
          current.add(parent.right);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.insert(8);
    root.insert(12);
    root.insert(9);
    root.insert(13);
    ArrayList<LinkedList<TreeNode>> result = createLevelLinkedList(root);
}
