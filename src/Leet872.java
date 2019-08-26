public class Leet872 {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(3);
    TreeNode root2 = new TreeNode(3);
    int[] nums1 = {5,1,6,2,9,8,7,4};
    int[] nums2 = {5,1,6,7,4,2,9,8};
    for (Integer i : nums1) {
      root1.insert(i);
    }
    for (Integer i : nums2) {
      root2.insert(i);
    }
    System.out.println("First tree: ");
    root1.printInOrder();
    System.out.println();
    System.out.println("Second tree: ");
    root2.printInOrder();
  }
}
