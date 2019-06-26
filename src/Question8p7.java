import java.util.ArrayList;

public class Question8p7 {

  public static ArrayList<String> getPerms(String str){
    if(str == null) return null;

    ArrayList<String> permutations = new ArrayList<String>();
    if(str.length() == 0) {    // Base case
      permutations.add("");
      return permutations;
    }

    char first = str.charAt(0); // get the first char
    String remainder = str.substring(1);
    ArrayList<String> words = getPerms(remainder);
    for(String word : words){
      for(int j = 0; j <= word.length(); j++){
        String s = insertChartAt(word, first, j);
        permutations.add(s);
      }
    }
    return permutations;
  }

  public static ArrayList<String> getPerms2(String remainder){
    int len = remainder.length();
    ArrayList<String> result = new ArrayList<String>();

    // Base case
    if(len == 0){
      result.add("");
      return result;
    }

    for(int i = 0; i < len; i++){
      // Remove char i and find permutations of remainder chars.
      String before = remainder.substring(0, i);
      String after = remainder.substring(i + 1, len);
      ArrayList<String> partials = getPerms2(before + after);

      // Prepend char i to each permutation
      for(String s : partials){
        result.add(remainder.charAt(i) + s);
      }
    }
    return result;
  }

  // Insert char c at index i in word
  private static String insertChartAt(String word, char c, int i){
    String start = word.substring(0, i);
    String end = word.substring(i);
    return start + c + end;
  }

  public static void main(String[] args) {
    String str = "ab";
    ArrayList<String> result = getPerms2(str);
    for(String s : result){
      System.out.println(s);
    }
  }
}
