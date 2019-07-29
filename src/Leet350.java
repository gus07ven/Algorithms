import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Leet350 {

  public static int[] getIntersection(int[] nums1, int[] nums2){
    HashMap<Integer, Integer> mapFirst = new HashMap<Integer, Integer>();
    ArrayList<Integer> common = new ArrayList<Integer>();

    for(int i = 0; i < nums1.length; i++)
    {
      if(mapFirst.containsKey(nums1[i])) mapFirst.put(nums1[i], mapFirst.get(nums1[i])+1);
      else mapFirst.put(nums1[i], 1);
    }

    for(int i = 0; i < nums2.length; i++)
    {
      if(mapFirst.containsKey(nums2[i]) && mapFirst.get(nums2[i]) > 0)
      {
        common.add(nums2[i]);
        mapFirst.put(nums2[i], mapFirst.get(nums2[i])-1);
      }
    }

    int[] result = new int[common.size()];
    for(int i = 0; i < common.size(); i++)
    {
      result[i] = common.get(i);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums1 = {9,4,9,8,4,9};
    int[] nums2 = {4,9,5};
    Arrays.stream(getIntersection(nums1, nums2)).forEach(s -> System.out.print(s));
  }
}
