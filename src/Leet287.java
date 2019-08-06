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

  public static int findDuplicateConstSpaceTwo(int[] nums){

    // Find the intersection point of the two runners.
    int tortoise = nums[0];
    int hare = nums[0];
    do {
      tortoise = nums[tortoise];
      hare = nums[nums[hare]];
    } while (tortoise != hare);

    // Find the "entrance" to the cycle.
    int ptr1 = nums[0];
    int ptr2 = tortoise;
    while (ptr1 != ptr2) {
      ptr1 = nums[ptr1];
      ptr2 = nums[ptr2];
    }

    return ptr1;
  }

  public static void main(String[] args) {
    int[] nums = {2,5,9,6,9,3,8,9,7,1};
    System.out.println(findDuplicateConstSpaceTwo(nums));
  }
}
