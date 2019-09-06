public class StrPerm {

  public static void recPermute(String soFar, String rest){
    if(rest.length() == 0){
      System.out.println(soFar);
    } else {
      for (int i = 0; i < rest.length(); i++) {
        String remaining = rest.substring(0, i) + rest.substring(i + 1);
        recPermute(soFar + rest.substring(i, i + 1), remaining);
      }
    }
  }

  public static void main(String[] args) {
    String str = "abc";
    recPermute("", str);
  }
}
