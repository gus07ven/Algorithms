public class Question8p5 {

  public static int multiply(int num1, int num2) {
    int smallest = Math.min(num1, num2);
    int biggest = Math.max(num1, num2);
    return multiply2(biggest, smallest);
  }

  private static int multiply2(int biggest, int smallest){
    if(smallest == 1) return biggest;
    else return biggest + multiply2(biggest, smallest - 1);
  }

  public static int minProduct(int a, int b){
    int bigger = a < b ? b : a;
    int smaller = a < b ? a : b;
    int memo[] = new int[smaller + 1];
    return minProductHelper(smaller, bigger, memo);
  }

  private static int minProductHelper(int smaller, int bigger, int[] memo){
    if(smaller == 0) {
      return 0;
    } else if(smaller == 1){
      return bigger;
    } else if(memo[smaller] > 0){
      return memo[smaller];
    }
    // Compute half. If uneven, compute other half. If even, double it.
    int s = smaller >> 1;
    int side1 = minProductHelper(s, bigger, memo);
    int side2 = side1;
    if(smaller % 2 == 1){
      side2 = minProductHelper(smaller - s, bigger, memo);
    }
    memo[smaller] = side1 + side2;
    return memo[smaller];
  }

  public static void main(String[] args) {
    int num1 = 8;
    int num2 = 9;
//    System.out.println(multiply(num1, num2));
    System.out.println(minProduct(num1, num2));
  }
}
