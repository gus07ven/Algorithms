import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet47 {

  public static List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
  }

  private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
    } else{
      for(int i = 0; i < nums.length; i++){
        if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
        used[i] = true;
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, used);
        used[i] = false;
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] input = {1, 1, 2, 2};

    List<List<Integer>> result = permuteUnique(input);

    for (List<Integer> a : result) {
      System.out.println();
      for (Integer i : a) {
        System.out.print(i + " ");
      }
    }
  }
}
