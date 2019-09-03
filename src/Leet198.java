import java.util.Arrays;

public class Leet198 {

  private static int[] memo;

  private static int rob(int[] nums) {
    return rob(nums, nums.length - 1);
  }

  private static int rob(int[] nums, int i) {
    if (i < 0) {
      return 0;
    }
    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
  }

  private static int robMemo(int[] nums){
    memo = new int[nums.length + 1];
    Arrays.fill(memo, -1);
    return robMemo(nums, nums.length - 1);
  }

  private static int robMemo(int[] nums, int i){
    if(i < 0){
      return 0;
    }
    if(memo[i] >= 0){
      return memo[i];
    }
    int result = Math.max(robMemo(nums, i - 2) + nums[i], robMemo(nums, i - 1));
    memo[i] = result;
    return result;
  }

  private static int robIter(int[] nums){
    if(nums.length == 0) return 0;
    int[] memo = new int[nums.length + 1];
    memo[0] = 0;
    memo[1] = nums[0];
    for(int i = 1; i < nums.length; i++){
      int val = nums[i];
      memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
    }
    return memo[nums.length];
  }

  private static int robIterVar(int[] nums){
    if(nums.length == 0) return 0;
    int prev1 = 0;
    int prev2 = 0;
    for(int num : nums){
      int tmp = prev1;
      prev1 = Math.max(prev2 + num, prev1);
      prev2 = tmp;
    }
    return prev1;
  }

  public static void main(String[] args) {
    int[] houses = {2,7,9,3,1};
    System.out.println("Top down DP solution: " + rob(houses));
    System.out.println("Top down DP memoized solution: " + robMemo(houses));
    System.out.println("Bottom up DP iterative memoized solution: " + robIter(houses));
    System.out.println("Bottom up DP iterative variables solution: " + robIterVar(houses));
  }
}
