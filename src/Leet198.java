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
    return rob(nums, nums.length - 1);
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

  public static void main(String[] args) {
    int[] houses = {2,7,9,3,1};
    System.out.println("Top down DP solution: " + rob(houses));
    System.out.println("Top down DP memoized solution: " + robMemo(houses));
  }
}
