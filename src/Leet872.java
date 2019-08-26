import java.util.ArrayList;

public class Leet872 {

  public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
    if (root1 == null & root2 == null) return true;
    if (root1 == null & root2 != null) return false;
    if (root1 != null & root2 == null) return false;

    ArrayList<Integer> leaves1 = getLeaves(root1, new ArrayList<>());
    ArrayList<Integer> leaves2 = getLeaves(root2, new ArrayList<>());

    if (leaves1.size() != leaves2.size()) return false;
    else return leaves1.equals(leaves2);
  }

  public static ArrayList<Integer> getLeaves(TreeNode root, ArrayList<Integer> leaves) {
    if (root == null) return null;
    if (root.left != null) {
      getLeaves(root.left, leaves);
    }
    if (root.left == null & root.right == null) {
      leaves.add(root.data);
    }
    if (root.right != null) {
      getLeaves(root.right, leaves);
    }
    return leaves;
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(3);
    TreeNode root2 = new TreeNode(3);
    int[] nums1 = {5, 1, 6, 2, 9, 8, 7, 4};
    int[] nums2 = {5, 1, 6, 2, 9, 8, 7, 4};    // 7,4,2,9,8
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
    System.out.println();
    System.out.println("Do the trees have similar leaves? " + leafSimilar(root1, root2));
  }
}
