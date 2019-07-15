public class Leet116 {

  public static void connectRecursive(TreeNode current) {
    if (current == null) return;
    if (current.next != null) connectRecursive(current.next);

    if (current.left != null) {
      if (current.right != null) {
        current.left.next = current.right;
        current.right.next = getNextRight(current);
      } else {
        current.left.next = getNextRight(current);
      }
      connectRecursive(current.left);
    } else if (current.right != null) {
      current.right.next = getNextRight(current);
    } else {
      connectRecursive(getNextRight(current));
    }
  }

  public static TreeNode getNextRight(TreeNode current) {
    TreeNode temp = current.next;
    while (temp != null) {
      if (temp.left != null) return temp.left;
      if (temp.right != null) return temp.right;
      temp = temp.next;
    }
    return null;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    connectRecursive(root);
    System.out.println(root.left.right.next.data);
  }
}


