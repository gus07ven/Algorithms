public class Question4p2 {

  public static TreeNode minimalTree(int[] nums){
    if(nums.length == 0) return null;
    int mid = nums.length / 2;
    int high = nums.length - 1;
    int helperLeft = mid - 1;
    int helperRight = mid + 1;
    int counter = 0;
    TreeNode root = new TreeNode(nums[mid]);
    boolean loop = true;

    while(counter < high){
      if(!loop){
        root.insert(nums[helperLeft]);
        helperLeft--;
        loop = true;
      } else {
        root.insert(nums[helperRight]);
        helperRight++;
        loop = false;
      }
      counter++;
    }

    return root;
  }

  public static void main(String[] args) {
    int[] nums = {2, 7, 9, 10, 12, 15, 27};
    TreeNode result = minimalTree(nums);
    result.printInOrder();
  }
}
