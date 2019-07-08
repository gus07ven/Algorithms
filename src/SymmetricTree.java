import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.data == t2.data) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
  }

  public boolean isSymmetricIter(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode t1 = q.poll();
      TreeNode t2 = q.poll();
      if (t1 == null && t2 == null) continue;
      if (t1 == null || t2 == null) return false;
      if (t1.data != t2.data) return false;
      q.add(t1.left);
      q.add(t2.right);
      q.add(t1.right);
      q.add(t2.left);
    }
    return true;
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

    // Iterative solution
    SymmetricTree st2 = new SymmetricTree();
    System.out.println(st2.isSymmetricIter(root));
  }
}

