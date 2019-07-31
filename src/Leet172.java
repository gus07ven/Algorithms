public class Leet172 {

  public static int trailingZeroes(int n){
    return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println(trailingZeroes(n));
  }
}
