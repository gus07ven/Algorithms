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

  public static void main(String[] args) {
    int[] cost = {10, 15, 20};
    int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    System.out.println(minCostClimbingStairs(cost));
    System.out.println(minCostClimbingStairs(cost2));
  }
}
