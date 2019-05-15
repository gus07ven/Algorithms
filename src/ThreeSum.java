import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class ThreeSum {

  public static int count(int[] array){
    HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
    for (Integer num : array) {
      values.put(num, num);
    }

    int count = 0;
    for (int i = 0; i < array.length; i++){
      for (int j = i + 1; j < array.length; j++) {
        int frontTwoVals = array[i] + array[j];
        int inverse = values.getOrDefault(-frontTwoVals, Integer.MAX_VALUE);
        if (frontTwoVals + inverse == 0) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] array = {30, -40, -20, -10, 40, 0, 10, 5};
    Instant start = Instant.now();
    System.out.println(ThreeSum.count(array));
    Instant finish = Instant.now();
    long elapsedTime = Duration.between(start, finish).toMillis();
    System.out.println("Elapsed time: " + elapsedTime + " ms");
  }
}
