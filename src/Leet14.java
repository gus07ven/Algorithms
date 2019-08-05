import java.util.HashMap;

public class Leet14 {

  public static String longestCommonPrefix(String[] strs) {
    if(strs.length == 0) return "";
    if(strs.length == 1) return strs[0];
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < strs[0].length(); i++){
      char c = strs[0].charAt(i);
      for(int j = 1; j < strs.length; j++){
        if(i >= strs[j].length()) return sb.toString();
        if(c != strs[j].charAt(i)) return sb.toString();
      }
      sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String[] input = {"flower","flo","flight"};
    System.out.println(longestCommonPrefix(input));
  }
}
