import java.util.ArrayList;

public class Leet125 {

  public static boolean isPalindrome(String s) {
    if(s.isEmpty() || s.length() == 1) return true;

    s = s.replaceAll("[^\\w]","").toLowerCase();
    int leftPtr = 0;
    int rightPtr = s.length() - 1;
    int mid = s.length() / 2;
    while(leftPtr <= mid && rightPtr >= mid){
      if(s.toLowerCase().charAt(leftPtr) == s.toLowerCase().charAt(rightPtr)){
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
    String input = "A man, a plan, a canal: Panama";
    System.out.println(isPalTwo(input));
  }
}
