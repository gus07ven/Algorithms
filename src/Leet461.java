public class Leet461 {

  public static int HammingDistance(int a, int b){
    return Integer.bitCount(a ^ b);
  }

  public static int HammingDistanceImperative(int x, int y){
    if(x == 0 && y == 0) return 0;

    int result = x ^ y;
    int count = 0;
    for(int i = 0; i < Integer.BYTES * 8; i++){
      if((result & 1) == 1) {
        count++;
      }
      result >>= 1;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println("Number of one bits present:");
    System.out.println("Built-in method: " + HammingDistance(0,0));
    System.out.println("Imperative implementation: " + HammingDistanceImperative(-1,0));
  }
}
