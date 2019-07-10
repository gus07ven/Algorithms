import java.util.HashMap;

public class Leet217 {

  public static boolean containsDuplicate(int[] nums) {
    if(nums.length == 0) return false;

    HashMap<Integer,Integer> values = new HashMap<>();
    for(Integer i : nums){
      if(!values.containsKey(i)){
        values.put(i, 1);
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1,1,1,3,3,4,3,2,4,2};
    System.out.println(containsDuplicate(nums));
  }

}
