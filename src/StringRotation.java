public class StringRotation {

  static boolean isRotation(String s1, String s2){
    if(s1.length() == s2.length() && s1.length() > 0){
      String s1s1 = s1 + s1;
      return isSubstring(s1s1, s2);
    }
    return false;
  }

  static boolean isSubstring(String s1, String s2){
    return s1.contains(s2);
  }

  public static void main(String[] args) {
    String s1 = "erbottlewat";
    String s2 = "waterbottler";

    System.out.println(isRotation(s1, s2));
  }
}
