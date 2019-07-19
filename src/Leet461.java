public class Leet461 {

  public static int HammingDistance(int a, int b){
    return Integer.bitCount(a ^ b);
  }

  public static void main(String[] args) {
    System.out.println("Number of one bits present:");
    System.out.println("Built-in method: " + HammingDistance(0,0));
  }
}
