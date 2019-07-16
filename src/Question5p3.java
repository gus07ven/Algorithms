import java.util.ArrayList;

public class Question5p3 {

  public static int bitToWin(int num){
    int mask = 1;
    int consecOnes = 0;
    ArrayList<Integer> onesList = new ArrayList<>();

    for(int i = 0; i < 32; i++){
      if((num & mask) != 0){
        consecOnes++;
      } else {
        onesList.add(consecOnes);
        consecOnes = 0;
      }
      mask <<= 1;
    }

    int max = 0;
    for(int j = 1; j < onesList.size(); j++){
      int combineOneCounts = onesList.get(j - 1) + onesList.get(j);
      if(combineOneCounts > max) max = combineOneCounts;
    }

    return max + 1;
  }

  public static void main(String[] args) {
    int num = 1775;
    System.out.println(bitToWin(num));
  }
}
