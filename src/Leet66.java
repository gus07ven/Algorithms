import java.util.ArrayList;
import java.util.Collections;

public class Leet66 {

  public static int[] plusOne(int[] digits) {
    if(digits[digits.length - 1] < 9) {
      digits[digits.length - 1] += 1;
      return digits;
    } else {
      ArrayList<Integer> result = new ArrayList<>();
      int carryOver = 0;
      int total = 0;
      for(int i = digits.length - 1; i >= 0; i--){
        if(i == digits.length - 1) {
          total = digits[i] + 1;
        } else {
          total = digits[i] + carryOver;
        }
        carryOver = total / 10;
        result.add(total % 10);
      }
      if(carryOver != 0) result.add(carryOver);

      int[] res = new int[result.size()];
      int index = result.size() - 1;
      for(int i = 0; i < result.size(); i++){
        res[i] = result.get(index);
        index--;
      }
      return res;
    }
  }

  public static int[] plusOneImprov(int[] digits){
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
      if(digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int[] newNumber = new int [n+1];
    newNumber[0] = 1;

    return newNumber;
  }

  public static void main(String[] args) {
    int[] input = {9,9,9};

    for(Integer i : plusOneImprov(input)){
      System.out.print(i + " ");
    }
  }
}
