public class LongestCommonPrefix {

  public static int lcprefix(String first, String second){
    int N = Math.min(first.length(), second.length());
    for(int i = 0; i < N; i++){
      if(first.charAt(i) != second.charAt(i)) return i;
    }
    return N;
  }


  public static void main(String[] args) {
    String first = "prefetch";
    String second = "prefix";
    System.out.println(lcprefix(first, second));
  }
}
