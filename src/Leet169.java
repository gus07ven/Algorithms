import java.util.HashMap;
import java.util.Map;

public class Leet169 {

  public static int majorityElement(int[] nums) {
    HashMap<Integer, Integer> values = new HashMap<>();

    for(int i = 0; i < nums.length; i++){
      if(!values.containsKey(nums[i])){
        values.put(nums[i], 1);
      } else {
        values.put(nums[i], values.get(nums[i]) + 1);
      }
    }

    int majorityElement = 0;
    for(Map.Entry<Integer, Integer> entry : values.entrySet()){
      if(entry.getValue() > majorityElement && entry.getValue() > (nums.length/2)){
        majorityElement = entry.getKey();
      }
    }
    return majorityElement;
  }

  public static void main(String[] args) {
    int[] nums = {2,2,1,1,1,2,2};
    System.out.println(majorityElement(nums));
  }
}
