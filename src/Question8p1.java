import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Question8p1 {

  public static int countWays(int n){
    if(n < 0){
      return 0;
    } else if(n == 0){
      return 1;
    } else {
      return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }
  }

  public static int countWaysMemo(int n){
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return countWaysMemoImp(n, memo);
  }

  private static int countWaysMemoImp(int n, int[] memo) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else if (memo[n] > -1) {
      return memo[n];
    } else {
      memo[n] = countWaysMemoImp(n - 1, memo) + countWaysMemoImp(n - 2, memo) + countWaysMemoImp(n - 3, memo);
      return memo[n];
    }
  }

  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(countWays(3));
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println("Total time (ms): " + timeElapsed);

    Instant start2 = Instant.now();
    System.out.println(countWaysMemo(3));
    Instant finish2 = Instant.now();
    long timeElapsed2 = Duration.between(start2, finish2).toMillis();
    System.out.println("Total time (ms): " + timeElapsed2);
  }
}
