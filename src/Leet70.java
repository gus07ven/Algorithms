public class Leet70 {

  public static int climbStairs(int n) {
    if(n == 0) return 0;
    int[] stepsTable = new int[n + 1];
    return climbStairsAux(stepsTable, n);
  }

  private static int climbStairsAux(int[] stepsTable, int n){
    if(n == 0 || n == 1 || n == 2) return n;
    if(stepsTable[n] > 0) return stepsTable[n];

    if(stepsTable[n] == 0){
      stepsTable[n]= climbStairsAux(stepsTable, n - 2) + climbStairsAux(stepsTable, n - 1);
    }

    return stepsTable[n];
  }

  public static void main(String[] args) {
    System.out.println(climbStairs(5));
  }
}
