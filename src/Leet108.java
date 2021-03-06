public class Leet108 {

  static TreeNode root = null;

  public static TreeNode sortedArrayToBST(int[] nums){
    if(nums.length == 0) return null;

    int mid = (nums.length - 1) / 2;
    int leftP = mid - 1;
    int rightP = mid + 1;
    root = new TreeNode(nums[mid]);

    while(leftP >= 0 || rightP <= nums.length - 1){
      if(leftP >= 0){
        insertToTree(root, nums[leftP]);
        leftP--;
      }
      if(rightP <= nums.length - 1){
        insertToTree(root, nums[rightP]);
        rightP++;
      }
    }
    return root;
  }

  public static void insertToTree(TreeNode root, int val){
    if(root == null) {
      root = new TreeNode(val);
    } else {
      if(val <= root.data){
        if(root.left == null){
          root.left = new TreeNode(val);
        } else {
          insertToTree(root.left, val);
        }
      } else {
        if(root.right == null){
          root.right = new TreeNode(val);
        } else {
          insertToTree(root.right, val);
        }
      }
    }
  }

  public static TreeNode sortedArrayToBST2(int[] nums){
    if (nums.length == 0) {
      return null;
    }
    TreeNode head = helper(nums, 0, nums.length - 1);
    return head;
  }

  public static TreeNode helper(int[] num, int low, int high) {
    if (low > high) { // Done
      return null;
    }
    int mid = low + (high - low) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = helper(num, low, mid - 1);
    node.right = helper(num, mid + 1, high);
    return node;
  }

  public static void main(String[] args) {
    int[] nums = {-2, -2, -2, 8};
    TreeNode result = sortedArrayToBST2(nums);
    result.printInOrder();
  }
}
