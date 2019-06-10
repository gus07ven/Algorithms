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

  public static String sort(String s){
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
  }

  public static boolean permutation(String s, String t){
    return sort(s).equals(sort(t));
  }

  public static boolean permutation2(String s, String t){
    if(s.length() != t.length()) return false;

    int[] letters = new int[128]; // Assuming ASCII
    for(int i = 0; i < s.length(); i++){
      letters[s.charAt(i)]++;
    }

    for(int i = 0; i < t.length(); i++){
      letters[t.charAt(i)]--;
      if(letters[t.charAt(i)] < 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {

    String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloc"}};
    for(String[] pair : pairs){
      String word1 = pair[0];
      String word2 = pair[1];
      boolean anagram = isPermutation(word1, word2);
      System.out.println(word1 + "," + word2 + ": " + anagram);
    }

  }
}
