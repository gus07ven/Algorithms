public class Leet326 {

  public static boolean isPowerOfThree(int n){
    return n > 0 && 1162261467 % n == 0;
  }

  public static void main(String[] args) {
    System.out.println(isPowerOfThree(81));
    System.out.println(isPowerOfThree(4));
  }
}
