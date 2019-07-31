public class Leet172 {

  public static int trailingZeroes(int n){
    if(n == 0) return 0;

    return n / 5 + trailingZeroes(n / 5);
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println(trailingZeroes(n));
  }
}
