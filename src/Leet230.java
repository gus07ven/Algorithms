import apple.laf.JRSUIUtils;

public class Leet230 {

  int count = 0;
  int result = Integer.MIN_VALUE;

  public int kthSmallest(TreeNode root, int k) {
    kthSmallestHelper(root, k);
    return result;
  }

  public void kthSmallestHelper(TreeNode root, int k){
    if(root == null) return;
    kthSmallestHelper(root.left, k);
    count++;
    if(count == k) result = root.data;
    kthSmallestHelper(root.right, k);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    //    root.right.left = new TreeNode(7);
    //    root.right.right = new TreeNode(4);

    Leet230 leet = new Leet230();
    System.out.println(leet.kthSmallest(root, 5));
  }
}
