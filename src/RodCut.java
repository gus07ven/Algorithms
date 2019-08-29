import java.util.HashMap;

public class RodCut {

  private HashMap<Integer,Integer> priceTable;
  private int rodLength;

  public RodCut(HashMap<Integer,Integer> priceTable, int rodLength){
    this.priceTable = priceTable;
    this.rodLength = rodLength;
  }

  private int topDownDynProgImp(HashMap<Integer,Integer> priceTable, int rodLength){
    if(rodLength == 0) return 0;

    int maxRevenue = 0;
    for(int i = 1; i < rodLength; i++){
      int tp = priceTable.get(i) + topDownDynProgImp(priceTable, rodLength - i); // price + remainder of rod
      maxRevenue = Math.max(maxRevenue, tp);
    }
    return maxRevenue;
  }

  public int topDownMemo(HashMap<Integer,Integer> priceTable, int rodLength){
    HashMap<Integer,Integer> revenueTable = new HashMap<>();
    for(int i = 0; i < rodLength; i++){
      revenueTable.put(i + 1, Integer.MIN_VALUE);
    }
    return topDownMemoAux(priceTable, rodLength, revenueTable);
  }

  private int topDownMemoAux(HashMap<Integer, Integer> priceTable, int rodLength,
                             HashMap<Integer, Integer> revenueTable){
    if(revenueTable.get(rodLength) >= 0) return revenueTable.get(rodLength);
    int maxRevenue = 0;
      for(int i = 1; i < rodLength; i++){
        maxRevenue = Math.max(maxRevenue, priceTable.get(i) +
                topDownMemoAux(priceTable, rodLength - i, revenueTable));
      }
    revenueTable.put(rodLength, maxRevenue);
    return maxRevenue;
  }

  public int bottomUpMemo(HashMap<Integer, Integer> priceTable, int rodLength){
    HashMap<Integer,Integer> revenueTable = new HashMap<>();
    for(int i = 0; i <= rodLength; i++){
      revenueTable.put(i + 1, 0);
    }
    for(int j = 1; j < rodLength + 1; j++){
      int maxRevenue = 0;
      for(int i = 1; i < j; i++){
        maxRevenue = Math.max(maxRevenue, priceTable.get(i) + revenueTable.get(j - i));
      }
      revenueTable.put(j, maxRevenue);
    }
    return revenueTable.get(rodLength);
   }

  public static void main(String[] args) {
    HashMap<Integer,Integer> priceTable = new HashMap<>();
    priceTable.put(1, 1);
    priceTable.put(2, 5);
    priceTable.put(3, 8);
    priceTable.put(4, 9);
    priceTable.put(5, 10);
    priceTable.put(6, 17);
    priceTable.put(7, 17);
    priceTable.put(8, 20);
    priceTable.put(9, 24);
    priceTable.put(10, 30);
    int rodLength = 7;
    RodCut rc = new RodCut(priceTable, rodLength);
    System.out.println(rc.topDownDynProgImp(rc.priceTable, rc.rodLength));
    System.out.println(rc.topDownMemo(rc.priceTable, rc.rodLength));
    System.out.println(rc.bottomUpMemo(rc.priceTable, rc.rodLength)); 
  }
}
