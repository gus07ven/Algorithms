import java.util.HashMap;

public class RodCut {

  private HashMap<Integer,Integer> priceTable;
  private int rodLength;

  public RodCut(HashMap<Integer,Integer> priceTable, int rodLength){
    this.priceTable = priceTable;
    this.rodLength = rodLength;
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
  }
}
