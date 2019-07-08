import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Leet94 {

  public static List<Integer> inOrderIter(TreeNode root){
    if(root == null) return null;

    Stack<TreeNode> leftSubTree = new Stack<>();
    while(root != null){
      leftSubTree.push(root);
      root = root.left;
    }

    ArrayList<Integer> result = new ArrayList<>();
    TreeNode current = null;
    while(leftSubTree.size() != 1){
      current = leftSubTree.pop();
      result.add(current.data);
      if(current.right != null) result.add(current.right.data);
    }

    TreeNode rightRoot = leftSubTree.pop();
    result.add(rightRoot.data);
    rightRoot = rightRoot.right;

    while(rightRoot != null){
      if(rightRoot.left != null) result.add(rightRoot.left.data);
      result.add(rightRoot.data);
      rightRoot = rightRoot.right;
    }

    return result;
  }

  public static List<Integer> inOrderIter2(TreeNode root){
    List < Integer > res = new ArrayList<>();
    Stack < TreeNode > stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      res.add(curr.data);
      curr = curr.right;
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(9);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(11);
    root.right.right.left = new TreeNode(10);
    root.right.right.right = new TreeNode(15);

    TreeNode r2 = null;

    // Iterative solution
    List<Integer> result = inOrderIter2(root);
    for (Integer num : result) {
      System.out.println(num);
    }
  }
}
