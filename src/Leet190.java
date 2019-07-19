public class Leet190 {

  public static int reverseNumBits(int num){
    if(num == 0) return 0;

    StringBuilder reversed = new StringBuilder();
    for(int i = 0; i < (Integer.BYTES * 8); i++){
      int mask = 1 << i;
      if((mask & num) != 0){
        reversed.append(1);
      } else {
        reversed.append(0);
      }
    }

    return Integer.parseUnsignedInt(reversed.toString(), 2);
  }

  public static int reverseBits(int n) {
    int reversed = 0;
    for(int i = 0; i < Integer.BYTES * 8; i++){
      reversed = reversed << 1;
      reversed = reversed|(n & 1);
      n = n >> 1;
    }
    return reversed;
  }

  public static void main(String[] args) {
    System.out.println(reverseNumBits(1));
    System.out.println(reverseBits(1));
  }
}
