public class Question4p2 {

  public static TreeNode createMinimalTree(int[] array){
    return createMinimalTree(array, 0, array.length - 1);
  }

  public static TreeNode createMinimalTree(int[] array, int start, int end){
    if(end < start){
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode n = new TreeNode(array[mid]);
    n.left = createMinimalTree(array, start, mid - 1);
    n.right = createMinimalTree(array, mid + 1, end);
    return n;
  }

  public static void main(String[] args) {
    int[] nums = {2, 7, 9, 10, 12, 15, 27};
    TreeNode result = createMinimalTree(nums);
    result.printInOrder();
  }
}
