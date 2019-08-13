import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leet347 {

  public static List<Integer> topKFrequent(int[] nums, int k) {

    List<Integer> result = new ArrayList<>();
    HashMap<Integer, Integer> frequency = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      if(!frequency.containsKey(nums[i])){
        frequency.put(nums[i], 1);
        if(frequency.get(nums[i]) == k) result.add(nums[i]);
      } else {
        frequency.replace(nums[i], frequency.get(nums[i]) + 1);
        if(frequency.get(nums[i]) == k) result.add(nums[i]);
      }
    }
    if(result.isEmpty()){
      for (Integer num : nums) {
        result.add(num);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {-1,2};
    int k = 3;
    List<Integer> result = topKFrequent(nums, k);
    for (Integer i : result) {
      System.out.print(i + ", ");
    }
  }
}
