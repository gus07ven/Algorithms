import java.util.HashSet;
import java.util.Set;

public class Leet202 {

  public static boolean isHappy(int n) {
    if (n < 0) return false;

    Set<Integer> numsSeen = new HashSet<>();

    while (n > 1) {
      int newNum = 0;

      n = newNum;
    }
    return true;
  }

  public static void main(String[] args) {
    int happy = 19;
    System.out.println(isHappy(happy));
  }
}
