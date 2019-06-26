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
    return minProductHelper(smaller, bigger);
  }

  private static int minProductHelper(int smaller, int bigger){
    if(smaller == 0) {
      return 0;
    } else if(smaller == 1){
      return bigger;
    }

    // Compute half. If uneven, compute other half. If even, double it.
    int s = smaller >> 1;
    int halfProd = minProductHelper(s, bigger);
    if(smaller % 2 == 0){
      return halfProd + halfProd;
    } else {
      return halfProd + halfProd + bigger;
    }
  }

  public static void main(String[] args) {
    int num1 = 8;
    int num2 = 7;
//    System.out.println(multiply(num1, num2));
    System.out.println(minProduct(num1, num2));
  }
}
