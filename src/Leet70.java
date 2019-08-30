public class Leet70 {

  public static int climbStairs(int n) {
    if(n == 0) return 0;
    int[] stepsTable = new int[n + 1];
    return climbStairsAux(stepsTable, n);
  }

  private static int climbStairsAux(int[] stepsTable, int n){
    return n;
  }

  public static void main(String[] args) {
    System.out.println(climbStairs(5));
  }
}
