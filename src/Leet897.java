public class Leet897 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    Object[] nums = {3, 6, 2, 4, 8, 1, 7, 9};
    for (Object i : nums) {
      root.insert((int) i);
    }
    root.printInOrder();
  }
}

