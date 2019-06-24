import java.time.Duration;
import java.time.Instant;

public class FiboTech {

  public static int recursiveFibo(int n){
    if(n == 0) return 0;
    if(n == 1) return 1;
    return recursiveFibo(n - 1) + recursiveFibo(n - 2);
  }

  public static int memoFibo(int n){
    return memoFiboImp(n, new int[n + 1]);
  }

  private static int memoFiboImp(int n, int[] memo){
    if(n == 0 || n == 1) return n;

    if(memo[n] == 0){
      memo[n] = memoFiboImp(n - 1, memo) + memoFiboImp(n - 2, memo);
    }
    return memo[n];
  }

  public static int dynamicFibo(int n){
    if(n == 0) return 0;
    else if(n == 1) return 1;

    int[] memo = new int[n];
    memo[0] = 0;
    memo[1] = 1;
    for(int i = 2; i < n; i++){
      memo[i] = memo[i - 1] + memo[i - 2];
    }
    return memo[n - 1] + memo[n - 2];
  }

  public static int iterativeFibo(int n){
    if(n == 0) return 0;
    int a = 0;
    int b = 1;
    for(int i = 2; i < n; i++){
      int c = a + b;
      a = b;
      b = c;
    }
    return a + b;
  }

  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(recursiveFibo(40));
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println("Total time (ms): " + timeElapsed);

    Instant start2 = Instant.now();
    System.out.println(memoFibo(40));
    Instant finish2 = Instant.now();
    long timeElapsed2 = Duration.between(start2, finish2).toMillis();
    System.out.println("Total time (ms): " + timeElapsed2);

    Instant start3 = Instant.now();
    System.out.println(dynamicFibo(40));
    Instant finish3 = Instant.now();
    long timeElapsed3 = Duration.between(start3, finish3).toMillis();
    System.out.println("Total time (ms): " + timeElapsed3);

    Instant start4 = Instant.now();
    System.out.println(iterativeFibo(40));
    Instant finish4 = Instant.now();
    long timeElapsed4 = Duration.between(start4, finish4).toMillis();
    System.out.println("Total time (ms): " + timeElapsed4);
  }
}
