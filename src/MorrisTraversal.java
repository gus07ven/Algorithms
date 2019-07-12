public class MorrisTraversal {

  public static void inorder(TreeNode root) {
    TreeNode current = root;

    while (current != null) {
      if (current.left == null) {
        System.out.println(current.data);
        current = current.right;
      } else {
        TreeNode predecessor = findPredecessor(current, current.left);
        if (predecessor.right == null) {
          predecessor.right = current;
          current = current.left;
        } else {
          predecessor.right = null;
          System.out.println(current.data);
          current = current.right;
        }
      }
    }
  }

  public static TreeNode findPredecessor(TreeNode current, TreeNode predecessor) {
    while (predecessor.right != null && predecessor.right != current) {
      predecessor = predecessor.right;
    }
    return predecessor;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.insert(3);
    root.insert(9);
    root.insert(2);
    root.insert(4);
    root.insert(1);
    root.insert(7);
    root.insert(12);
    //root.printInOrder();

    inorder(root);
  }
}
