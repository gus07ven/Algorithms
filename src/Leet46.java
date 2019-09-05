import java.util.ArrayList;
import java.util.List;

public class Leet46 {

  public static List<List<Integer>> permute(int[] nums){
    return new ArrayList<>();
  }

    public static void main(String[] args) {
      int[] input = {1,2,3};

      List<List<Integer>> result = permute(input);

      for (List<Integer> a : result) {
        System.out.println();
        for(Integer i : a){
          System.out.print(i + " ");
        }
      }
    }
}
