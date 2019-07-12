public class MorrisTraversal {

  public static void inorder(TreeNode root){
    TreeNode current = root;

    while(current != null){
      if(current.left == null){
        System.out.println(current.data);
        current = current.right;
      } else {
        TreeNode predecessor = findPredecessor(current, current.left);
        if(predecessor.right == null){
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

  public TreeNode findPredecessor(TreeNode current, TreeNode predecessor){
    while(predecessor.right != null && predecessor.right != current){
      predecessor = predecessor.right;
    }
    return predecessor;
  }
}
