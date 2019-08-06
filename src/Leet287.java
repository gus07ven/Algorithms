import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet287 {

  public static int findDuplicate(int[] nums) {

    Arrays.sort(nums);
    Set<Integer> set = new HashSet<>();
    int answer = 0;
    for(int i = 0; i < nums.length; i++){
      if(!set.contains(nums[i])) set.add(nums[i]);
      else {
        answer = nums[i];
        break;
      }
    }
    return answer;
  }

  // Works for one duplicate
  public static int findDuplicateConstSpace(int[] nums){

    return Arrays.stream(nums).sum() - (((nums.length - 1) * (nums.length)) / 2);
  }

  public static void main(String[] args) {
    int[] nums = {3,1,3,4,2};
    System.out.println(findDuplicateConstSpace(nums));
  }
}
