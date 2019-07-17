import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Question5p4 {

  public static int getNextArith(int n){
    ArrayList<Integer> bitsList = getPC0C1(n);
    int p = bitsList.get(0);
    int c0 = bitsList.get(1);
    int c1 = bitsList.get(2);

    return n + (1 << c0) + (1 << (c1 - 1)) - 1;
  }

  public static int getPrevArith(int n){
    ArrayList<Integer> bitsList = getPC0C1(n);
    int p = bitsList.get(0);
    int c0 = bitsList.get(1);
    int c1 = bitsList.get(2);

    return n - (1 << c1) - (1 << (c0 - 1)) + 1;
  }

  public static ArrayList<Integer> getPC0C1(int n){
    // Compute c0 and c1
    int c = n;
    int c0 = 0;
    int c1 = 0;

    while(((c & 1) == 0) && (c != 0)){
      c0++;
      c >>= 1;
    }

    while((c & 1) == 1){
      c1++;
      c >>= 1;
    }

    // Error if n == 11..1100...00, then there is no bigger number with the same numbers of 1s.
    if(c0 + c1 == 31 || c0 + c1 == 0){
      throw new NoSuchElementException("There's no bigger number with the same numbers of 1s.");
    }
    int p = c0 + c1;

    ArrayList<Integer> results = new ArrayList<>();
    results.add(p);
    results.add(c0);
    results.add(c1);

    return results;
  }

  public static void main(String[] args) {
    int n = 50;
    System.out.println(getNextArith(n));
    System.out.println(getPrevArith(n));
  }
}
