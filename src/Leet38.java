import java.util.ArrayList;

public class Leet38 {

  public static String countAndSay(int n) {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> firstLevel = new ArrayList<>();
    firstLevel.add(1);
    result.add(firstLevel);

    for(int i = 1; i < n; i++){
      ArrayList<Integer> prev = result.get(0);
      ArrayList<Integer> next = new ArrayList<>();
      int size = prev.size();
      int curr = prev.get(i);
    }
    return "";
  }

  public static void main(String[] args) {
    int n = 3;
    System.out.println(countAndSay(n));
  }
}
