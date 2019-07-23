import java.util.Arrays;

public class Leet121 {

  public static int maxProfit(int[] prices){
    if(prices.length < 2) return 0;

    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;
    for(int i = 0; i < prices.length; i++){
      if(prices[i] < minPrice) minPrice = prices[i];
      else if(prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] nums = {7,1,5,3,6,4};
    System.out.println(maxProfit(nums));

    System.out.println();
    int[] nums2 = {1,1,1,1};
    System.out.println(maxProfit(nums2));

    System.out.println();
    int[] nums3 = {1};
    System.out.println(maxProfit(nums3));
  }
}
