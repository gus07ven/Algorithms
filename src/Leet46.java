import java.util.*;

public class Leet46 {

  public static List<List<Integer>> permute(int[] nums){
    List<List<Integer>> results = new ArrayList<>();
    backtrack(results, new ArrayList<Integer>(), new HashSet<>(), nums);
    return results;
  }

  private static void backtrack(List<List<Integer>> results, List<Integer> soFar, Set<Integer> soFarSet, int [] nums){
    if(soFar.size() == nums.length){
      results.add(new ArrayList<>(soFar));
    } else{
      for(int i = 0; i < nums.length; i++){
        if(soFarSet.contains(nums[i])) continue;
        soFarSet.add(nums[i]);
        soFar.add(nums[i]);
        backtrack(results, soFar, soFarSet, nums);
        soFarSet.remove(soFar.get(soFar.size() - 1));
        soFar.remove(soFar.size() - 1);
      }
    }
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
