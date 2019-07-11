import java.util.HashMap;

public class Question4p12 {

  public static int countPathsWithSum(TreeNode root, int targetSum){
    return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
  }

  public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount){
    if(node == null) return 0;

    // Count paths with sum ending at the current node
    runningSum += node.data;
    int sum = runningSum - targetSum;
    int totalPaths = pathCount.getOrDefault(sum, 0);

    if(runningSum == targetSum){
      totalPaths++;
    }

    // Increment pathCount, recurse, then decrement pathCount
    incrementHashTable(pathCount, runningSum, 1); // Increment path count
    totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
    totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
    incrementHashTable(pathCount, runningSum, -1); // Decrement path count

    return totalPaths;
  }

  private static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta){
    int newCount = hashTable.getOrDefault(key, 0) + delta;
    if(newCount == 0){  // Remove when zero to reduce space usage
      hashTable.remove(key);
    } else {
      hashTable.put(key, newCount);
    }
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(10);
    t1.left = new TreeNode(5);
    t1.right = new TreeNode(-3);
    t1.left.left = new TreeNode(3);
    t1.left.left.left = new TreeNode(3);
    t1.left.left.right = new TreeNode(-2);
    t1.left.right = new TreeNode(1);
    t1.left.right.right = new TreeNode(2);
    t1.right.right = new TreeNode(11);
    int targetSum = 8;

    System.out.println("The number of paths that add up to " + targetSum + " are: " + countPathsWithSum(t1, targetSum));
  }
}
