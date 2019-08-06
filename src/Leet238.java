
public class Leet238 {

  // NOTE: regular division is not allowed AND has to be solved in O(n)
  public static int[] productExceptSelf(int[] nums) {

    int[] left = new int[nums.length];
    left[0] = 1;
    for(int i = 1 ; i < nums.length; i++){
      left[i] = left[i - 1] * nums[i - 1];
    }

    int[] right = new int[nums.length];
    right[nums.length - 1] = 1;
    for(int i = nums.length - 2 ; i >= 0 ; i--){
      right[i] = right[i + 1] * nums[i + 1];
    }

    int[] result = new int[nums.length];
    for(int k = 0; k < nums.length; k++){
      result[k] = left[k] * right[k];
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    System.out.println(productExceptSelf(nums));
  }
}
