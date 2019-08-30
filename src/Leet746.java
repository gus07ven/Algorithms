public class Leet746 {

  public static int minCostClimbingStairs(int[] cost) {
    int[] mc = new int[cost.length + 1];
    mc[0] = cost[0];
    mc[1] = cost[1];

    for (int i = 2; i <= cost.length; i++) {
      int costV = (i == cost.length) ? 0 : cost[i];
      mc[i] = Math.min(mc[i - 1] + costV, mc[i - 2] + costV);
    }
    return mc[cost.length];
  }

  public static int minCostClimbingStairsOptSpace(int[] cost) {
    int a = cost[0];
    int b = cost[1];
    int result = Math.min(a, b);

    for (int i = 2; i <= cost.length; i++) {
      int c = i == cost.length? 0: cost[i];
      result = Math.min(a + c, b + c);
      a = b;
      b = result;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] cost = {10, 15, 20};
    int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    System.out.println(minCostClimbingStairs(cost));
    System.out.println(minCostClimbingStairs(cost2));
    System.out.println(minCostClimbingStairsOptSpace(cost));
    System.out.println(minCostClimbingStairsOptSpace(cost2));
  }
}
