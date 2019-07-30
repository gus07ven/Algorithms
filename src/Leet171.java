
public class Leet171 {

  public static int titleToNumber(String s) {
    if(s.length() == 0) return 0;

    int result = 0;
    for(int i = 0 ; i < s.length(); i++) {
      result = result * 26 + (s.charAt(i) - 'A' + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    String str = "AAA";
    System.out.println(titleToNumber(str));
  }
}
