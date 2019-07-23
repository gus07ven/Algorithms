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

  public static int maxProfitFunc(int[] prices){
    return IntStream.range(1, prices.length).
            map(i -> prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0).
            sum();
  }

  public static void main(String[] args) {
    int[] nums = {7,1,5,3,6,4};
    System.out.println(maxProfit(nums));
    System.out.println(maxProfitFunc(nums));
  }
}
