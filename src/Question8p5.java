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

  public int minProduct(int a, int b){
    int bigger = a < b ? b : a;
    int smaller = a < b ? a : b;
    return minProductHelper(smaller, bigger);
  }

  public int minProductHelper(int smaller, int bigger){
    if(smaller == 0) {
      return 0;
    } else if(smaller == 1){
      return bigger;
    }
    // Compute half. If uneven, compute other half. If even, double it.
    int s = smaller >> 1;
    int side1 = minProductHelper(s, bigger);
    int side2 = side1;
    if(smaller % 2 == 1){
      side2 = minProductHelper(smaller - s, bigger);
    }
    return side1 + side2;
  }

  public static void main(String[] args) {
    int num1 = 100;
    int num2 = 100;
    System.out.println(multiply(num1, num2));
  }
}
