import java.util.ArrayList;

public class Question5p3 {

  public static int bitToWin(int num){
    if(~num == 0) return Integer.BYTES * 8;

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

  public static int bitToWinConstMem(int num){
    if(~num == 0) return Integer.BYTES * 8;

    int mask = 1;
    int currConsOnes = 0;
    int previousConsOnes = 0;
    int max = 0;
    int combineOnes = 0;

    for(int i = 0; i < 32; i++){
      if((num & mask) != 0){
        currConsOnes++;
      } else {
        combineOnes = previousConsOnes + currConsOnes;
        if(combineOnes > max) max = combineOnes;
        previousConsOnes = currConsOnes;
        currConsOnes = 0;
      }
      mask <<= 1;
    }
    return max + 1;
  }

  public static void main(String[] args) {
    int num = -1;
    System.out.println(bitToWinConstMem(num));
  }
}
