import java.util.ArrayList;

public class Leet125 {

  public static boolean isPalindrome(String s) {
    if(s.isEmpty()) return true;

    ArrayList<Character> alphaNumStr = new ArrayList<>();
    for(int i = 0; i < s.length(); i++){
      if(Character.isLetterOrDigit(s.charAt(i))){
        alphaNumStr.add(s.toLowerCase().charAt(i));
      }
    }

    int leftPtr = 0;
    int rightPtr = alphaNumStr.size() - 1;
    int mid = alphaNumStr.size() / 2;
    while(leftPtr <= mid && rightPtr >= mid){
      if(alphaNumStr.get(leftPtr).equals(alphaNumStr.get(rightPtr))){
        leftPtr++;
        rightPtr--;
      } else {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalTwo(String s){
    s = s.replaceAll("[^\\w]","").toLowerCase();
    return s.equals(new StringBuilder(s).reverse().toString())? true: false;
  }

  public static void main(String[] args) {
    String input = "rooo";
    System.out.println(isPalTwo(input));
  }
}
