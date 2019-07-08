import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.data == t2.data)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);

    // Recursive solution
    SymmetricTree st = new SymmetricTree();
    System.out.println(st.isSymmetric(root));

  }
}

