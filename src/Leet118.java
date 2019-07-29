import java.util.ArrayList;
import java.util.List;

public class Leet118 {

  public static List<List<Integer>> generate(int numRows) {
    if(numRows < 1){
      List<List<Integer>> emptyList = new ArrayList<>();
      return emptyList;
    }

    List<List<Integer>> pasTri = new ArrayList<>();
    ArrayList<Integer> firstLevel = new ArrayList<>();
    firstLevel.add(1);
    pasTri.add(firstLevel);

    for(int i = 1; i < numRows; i++){
      List<Integer> prevLevel = pasTri.get(i - 1);
      List<Integer> currLevel = new ArrayList<>();
      currLevel.add(1);
      for(int j = 1; j < prevLevel.size(); j++){
        currLevel.add(prevLevel.get(j - 1) + prevLevel.get((j)));
      }
      currLevel.add(1);
      pasTri.add(currLevel);
    }
    return pasTri;
  }

  public static void main(String[] args) {
    int numRows = 0;
    List<List<Integer>> result = generate(numRows);

    // Print result
    for(List<Integer> list : result){
      for(Integer i : list){
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
