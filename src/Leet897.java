public class Leet897 {

  private static TreeNode result = null;
  private static TreeNode head = null;

  private static TreeNode increasingBST(TreeNode root) {
    if(root == null) return root;

    if(root.left != null){
      increasingBST(root.left);
    }

    if(result == null){
      result = new TreeNode(root.data);
      head = result;
    } else {
      result.left = null;
      result.right = new TreeNode(root.data);
      result = result.right;
    }

    if(root.right != null){
      increasingBST(root.right);
    }
    return head;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    Object[] nums = {3, 6, 2, 4, 8, 1, 7, 9};
    for (Object i : nums) {
      root.insert((int) i);
    }
    TreeNode result = increasingBST(root);
    result.printInOrder();
  }
}

