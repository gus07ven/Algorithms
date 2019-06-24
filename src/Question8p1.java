import java.time.Duration;
import java.time.Instant;

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

  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(countWays(25));
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println("Total time (ms): " + timeElapsed);
  }
}
