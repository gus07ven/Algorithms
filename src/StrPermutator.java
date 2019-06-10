import java.util.HashMap;

public class StrPermutator {

  public static boolean isPermutation(String first, String second){
    HashMap<Character, Integer> matcher = new HashMap<>();

    if(first.length() != second.length()) return false;
    char[] firstLowerCase = first.toLowerCase().toCharArray();
    char[] secondLowerCase = second.toLowerCase().toCharArray();

    for(char a : firstLowerCase){
      if(matcher.containsKey(a)) matcher.replace(a, matcher.get(a) + 1);
      else matcher.put(a, 1);
    }

    for(char b : secondLowerCase){
      if(!matcher.containsKey(b)) return false;
      else matcher.replace(b, matcher.get(b) - 1);
    }

    for(char key : matcher.keySet()){
      if(matcher.get(key) != 0) return false;
    }

    return true;
  }

  public static void main(String[] args) {

    // Assuming strings are of same length and characters can't be repeated
    String first = "Country";
    String second = "Trycoun";
    System.out.println(isPermutation(first, second));
  }
}
