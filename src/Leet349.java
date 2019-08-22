import java.util.HashSet;
import java.util.Set;

public class Leet349 {

  public static int[] intersection(int[] nums1, int[] nums2) {
    if(nums1.length == 0 || nums2.length == 0) {
      int[] res = {};
      return res;
    }

    Set<Integer> set = new HashSet<Integer>();
    for(Integer i : nums1){
      if(!set.contains(i)) set.add(i);
    }

    Set<Integer> prelim = new HashSet<Integer>();
    for(Integer a : nums2){
      if(set.contains(a)) prelim.add(a);
    }

    int[] result = new int[prelim.size()];
    int i = 0;
    for (Integer num : prelim) {
      result[i++] = num;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums1 = {4,9,5};
    int[] nums2 = {9,4,9,8,4};
    int[] result = intersection(nums1, nums2);

    for(Integer i : result){
      System.out.println(i);
    }
  }
}
