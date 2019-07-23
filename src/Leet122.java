import java.util.Arrays;
import java.util.stream.IntStream;

public class Leet122 {

  public static int maxProfit(int[] prices) {
    if(prices.length < 2) return 0;

    int profit = 0;
    for(int i = 1; i < prices.length; i++){
      int priceToday = prices[i - 1];
      int priceTomorrow = prices[i];
      int margin = priceTomorrow - priceToday;
      if(margin > 0) profit += margin;
    }
    return profit;
  }

  public static void main(String[] args) {
    int[] nums = {1,7};
    System.out.println(maxProfit(nums));
  }
}
