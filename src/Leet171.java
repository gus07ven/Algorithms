
public class Leet171 {

  public static int titleToNumber(String s) {
    if(s.length() == 0) return 0;

    int total = 0;
    char[] letters = s.toLowerCase().toCharArray();
    if(letters.length == 1) return Character.getNumericValue(letters[0]) - 9;

    return total;
  }

  public static void main(String[] args) {
    String str = "Z";
    System.out.println(titleToNumber(str));
  }
}
