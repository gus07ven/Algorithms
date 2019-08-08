public class Leet709 {

  public static String toLowerCase(String str) {
    if(str.isEmpty()) return "";

    StringBuilder lowercaseString = new StringBuilder();
    for (Character ch : str.toCharArray()) {
      if(Character.isUpperCase(ch)){
        int upper = ch + 32;
        lowercaseString.append((char) upper);
      } else {
        lowercaseString.append(ch);
      }
    }
    return lowercaseString.toString();
  }

  public static String toLowerCaseBuiltIn(String str){
    return str.toLowerCase();
  }

  public static void main(String[] args) {
    String input = "HelLO";
    System.out.println(toLowerCase(input));
  }
}
