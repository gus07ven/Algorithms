public class Leet326 {

  public static boolean isPowerOfThree(int n){
    return n > 0 && 1162261467 % n == 0;
  }

  public static boolean isPowerOfThree2(int n){
    if(n < 1) return false;

    while(n % 3 == 0){
      n = n / 3;
    }
    return n == 1;
  }

  public static boolean isPowerOfThree3(int n){
    double epsilon = .0001;
    return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
  }

  public static void main(String[] args) {
    System.out.println("O(1) method call results:");
    System.out.println(isPowerOfThree(81));
    System.out.println(isPowerOfThree(4));

    System.out.println();
    System.out.println("O(log3(n)) results:");
    System.out.println(isPowerOfThree2(81));
    System.out.println(isPowerOfThree2(4));

    System.out.println();
    System.out.println("O(?) results:");
    System.out.println(isPowerOfThree3(81));
    System.out.println(isPowerOfThree3(4));
  }
}
