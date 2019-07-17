public class Question5p6 {

  public static int numDiffBits(int num1, int num2){
    if(num1 == num2) return 0;

    int result = num1 ^ num2;
    return Integer.bitCount(result);
  }

  public static int bitSwapRequired(int a, int b){
    int count = 0;
    for(int c = a ^ b; c != 0; c = c >>> 1){
      count += c & 1;
    }
    return count;
  }

  public static void main(String[] args) {
    int num1 = 29;
    int num2 = 15;

    System.out.println(numDiffBits(num1, num2));
    System.out.println(bitSwapRequired(num1, num2));
  }
}
