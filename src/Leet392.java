public class Leet392 {

  public static boolean isSubsequence(String s, String t) {
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

  public static void main(String[] args) {
    String s = "ace";
    String t = "abcde";
    System.out.println(isSubsequence(s,t));
  }
}
