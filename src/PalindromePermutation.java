import java.util.HashMap;

public class PalindromePermutation {

  private static boolean isPalindromePermutation(String str){
    if(str.isEmpty()) return false;

    char[] strArr= str.toLowerCase().trim().toCharArray();
    HashMap<Character, Integer> letters = new HashMap<>();
    int pairs = 0;
    int ones = 0;
    int whiteSpaces = 0;

    for(char c : strArr){
      if(letters.containsKey(c)){
        if(letters.get(c) == 2) return false;
        else letters.replace(c, letters.get(c) + 1);
             pairs++;
      } else {
        if(Character.isWhitespace(c)) {
          whiteSpaces++;
          continue;
        }
        letters.put(c, 1);
        ones++;
      }
    }

    return (((pairs * 2) + (ones - pairs)) == (strArr.length - whiteSpaces));

  }

  public static void main(String[] args) {
    String odd = "taco cat";
    String even = "rotor";

    System.out.println(isPalindromePermutation(odd));
    System.out.println(isPalindromePermutation(even));
  }
}
