import java.util.Arrays;

public class Leet371 {

  public static int sum(int a, int b){
    while(b!=0){
      int c = a & b;
      a = a ^ b;
      b = c << 1;
    }
    return a;
  }

  public static int streamSum(int a, int b){
    return Arrays.stream(new int[] {a, b}).sum();
  }

  public static void main(String[] args) {

    System.out.println("Print imperative sum: ");
    System.out.println(sum(2, 3));

    System.out.println();
    System.out.println("Print functional sum: ");
    System.out.println(streamSum(2, 7));
  }
}
