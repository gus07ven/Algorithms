import javafx.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class Leet303 {

  private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

  public Leet303(int[] nums){
    for(int i = 0; i < nums.length; i++){
      int totalSoFar = 0;
      for(int j = i; j < nums.length; j++){
        totalSoFar += nums[j];
        map.put(new Pair<>(i, j), totalSoFar);
      }
    }
  }

  public int sumRange(int i, int j){
    return map.get(new Pair<>(i,j));
  }

  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    Leet303 le = new Leet303(nums);
    System.out.println(le.sumRange(0, 2));
    System.out.println(le.sumRange(2, 5));
    System.out.println(le.sumRange(0, 5));
  }
}
