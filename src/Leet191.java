public class Leet191 {

  public static int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for(int i = 0; i < 32; i++){
      if((n & mask) != 0){
        bits++;
      }
      mask <<= 1;
    }
    return bits;
  }

  public static void main(String[] args) {
    int num = 50;
    System.out.println(hammingWeight(num));
  }
}
