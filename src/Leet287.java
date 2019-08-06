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

  public static void main(String[] args) {
    int[] nums = {1,3,4,2,2};
    System.out.println(findDuplicate(nums));
  }
}
