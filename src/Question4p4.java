public class Question4p4 {

  public static int checkHeight(TreeNode root){
    if(root == null) return -1;

    int leftHeight = checkHeight(root.left);
    if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;     // Pass error up

    int rightHeight = checkHeight(root.right);
    if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

    int heightDifference = leftHeight - rightHeight;
    if(Math.abs(heightDifference) > 1){
      return Integer.MIN_VALUE;   // Found error -> pass it back
    } else {
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(17);
    root.insert(10);
    root.insert(19);
    root.insert(5);
    root.insert(2);

    System.out.println(checkHeight(root));
  }
}

