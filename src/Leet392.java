public class Leet392 {

  // 12 ms to solve problem
  private static boolean isSubsequence(String s, String t) {
    if(s.length() == 0) return true;
    if(t.length() == 0) return false;

    int sPos = 0;
    for(int i = 0; i < t.length(); i++){
      if(s.charAt(sPos) == t.charAt(i)){
        if(sPos == s.length() - 1) return true;
        else sPos++;
      }
    }
    return false;
  }

  // 0 ms to solve problem
  private static boolean isSubsequenceOptimized(String s, String t) {
    if(s.length() == 0) return true;
    if(t.length() == 0) return false;

    int tIndex = -1;
    for (char c : s.toCharArray()) {
      tIndex = t.indexOf(c, tIndex + 1);
      if (tIndex < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "ace";
    String t = "abcde";
    System.out.println(isSubsequence(s,t));
    System.out.println(isSubsequenceOptimized(s,t));
  }
}
