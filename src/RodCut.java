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
      maxRevenue = Math.max(maxRevenue, priceTable.get(i) + topDownDynProgImp(priceTable, rodLength - i));
    }
    return maxRevenue;
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
  }
}
