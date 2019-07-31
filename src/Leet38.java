import java.util.ArrayList;

public class Leet38 {

  public static String countAndSay(int n) {
    int count = 1;
    String str = "1";
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < n ; i++){
      sb.setLength(0);
      count = 1;
      for(int j = 1; j < str.length(); j++){
        if(str.charAt(j - 1) != str.charAt(j)){
          sb.append(count);
          sb.append(str.charAt(j-1));
          count = 0;
        }
        count++;
      }
      if(count > 0){
        sb.append(count);
        sb.append(str.charAt(str.length()-1));
      }
      str = sb.toString();
    }
    return str;
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println(countAndSay(n));
  }
}
