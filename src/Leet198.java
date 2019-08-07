import java.util.*;
import java.util.HashMap;

public class Leet198 {

  // TODO: Finish this one.
  private static int rob(int[] nums) {
    if(nums.length == 0) return 0;

    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      map.put(i, nums[i]);
    }

    Set test = map.entrySet();

    return 1;
  }

  public static void main(String[] args) {
    int[] houses = {2,1,1,2};
    System.out.println(rob(houses));
  }
}
