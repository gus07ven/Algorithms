import com.sun.tools.javac.util.List;
import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Arrays;

public class Question8p4 {

  public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
    ArrayList<ArrayList<Integer>> allsubsets;
    if(set.size() == index){  // Base case - add empty set
      allsubsets = new ArrayList<ArrayList<Integer>>();
      allsubsets.add(new ArrayList<Integer>()); // Empty set
    } else {
      allsubsets = getSubsets(set,index + 1);
      int item = set.get(index);
      ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
      for(ArrayList<Integer> subset : allsubsets){
        ArrayList<Integer> newsubset = new ArrayList<Integer>();
        newsubset.addAll(subset);
        newsubset.add(item);
        moresubsets.add(newsubset);
      }
      allsubsets.addAll(moresubsets);
    }
    return allsubsets;
  }

  public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set){
    ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
    int max = 1 << set.size();    // Compute 2^n
    for(int k = 0; k < max; k++){
      ArrayList<Integer> subset = convertIntToSet(k, set);
      allsubsets.add(subset);
    }
    return allsubsets;
  }

  public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set){
    ArrayList<Integer> subset = new ArrayList<Integer>();
    int index = 0;
    for(int k = x; k > 0; k >>= 1){
      if((k & 1) == 1){
        subset.add(set.get(index));
      }
      index++;
    }
    return subset;
  }

  public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private static void backtrack(ArrayList<ArrayList<Integer>> list , ArrayList<Integer> tempList, int [] nums, int start) {
    list.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      backtrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> set = new ArrayList<>();
    set.add(1);
    set.add(2);
    set.add(3);

    System.out.println(getSubsets(set, 0));
    System.out.println(getSubsets2(set));

    int[] test = {1,2,3};
    System.out.println(subsets(test));
  }
}
