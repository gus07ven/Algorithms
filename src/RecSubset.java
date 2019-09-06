public class RecSubset {

  public static void recSubsets(String soFar, String rest){
    if(rest.isEmpty()) {
      System.out.println(soFar);
    }
    else {
      recSubsets(soFar + rest.substring(0, 1), rest.substring(1));
      recSubsets(soFar, rest.substring(1));
    }
  }

  public static void main(String[] args) {
    String set = "123";
    recSubsets("", set);
  }
}
