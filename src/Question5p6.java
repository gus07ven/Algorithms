public class Question5p6 {

  public static int numDiffBits(int num1, int num2){
    if(num1 == num2) return 0;

    int result = num1 ^ num2;
    return Integer.bitCount(result);
  }

  public static void main(String[] args) {
    int num1 = 29;
    int num2 = 15;

    System.out.println(numDiffBits(num1, num2));
  }
}
