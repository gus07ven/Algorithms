public class Question4p8 {

  public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
    if(!covers(root, p) || !covers(root, q)){
      return null;
    }
    return ancestorHelper(root, p, q);
  }

  static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q){
    if(root == null || root == p || root == q){
      return root;
    }

    boolean pIsOnLeft = covers(root.left, p);
    boolean qIsOnLeft = covers(root.left, q);

    // Nodes on different sides. Common ancestor is root.
    if(pIsOnLeft != qIsOnLeft){
      return root;
    }

    TreeNode childSide = pIsOnLeft ? root.left : root.right;
    return ancestorHelper(childSide, p, q);
  }

  static boolean covers(TreeNode root, TreeNode p){
    if(root == null) return false;
    if(root == p) return true;
    return covers(root.left, p) || covers(root.right, p);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(9);
    root.left.left = new TreeNode(8);
    root.left.right = new TreeNode(12);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(4);

    System.out.println(commonAncestor(root,root.left.left, root.left.right).data);
  }
}
