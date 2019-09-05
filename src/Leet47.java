import java.util.ArrayList;
import java.util.List;

public class Leet47 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    //    backtrack(results, new ArrayList<>(), nums);
    return results;
  }

  public static void main(String[] args) {
    int[] input = {1, 1, 2};

    List<List<Integer>> result = permuteUnique(input);

    for (List<Integer> a : result) {
      System.out.println();
      for (Integer i : a) {
        System.out.print(i + " ");
      }
    }
  }
}
