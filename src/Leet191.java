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

  public static int hammingWeight2(int n) {
    int sum = 0;
    while (n != 0) {
      sum++;
      n &= (n - 1);
    }
    return sum;
  }

  public static void main(String[] args) {
    int num = 50;
    System.out.println(hammingWeight(num));
    System.out.println(hammingWeight2(num));
  }
}
