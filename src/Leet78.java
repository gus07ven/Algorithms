import java.util.ArrayList;
import java.util.List;

public class Leet78 {

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    result.add(new ArrayList<>());

    for (int num : nums){

      int length = result.size();
      for (int i = 0 ; i < length; i++){
        List<Integer> tmp = new ArrayList<>(result.get(i));
        tmp.add(num);
        result.add(tmp);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    subsets(nums);
  }

}
