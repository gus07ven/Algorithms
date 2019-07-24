public class Primality {

  private static boolean primeNaive(int n){
    if(n < 2) return false;

    for(int i = 2; i < n; i++){
      if(n % i == 0){
        return false;
      }
    }
    return true;
  }

  private static boolean primeBetter(int n){
    if(n < 2) return false;

    int sqrt = (int) Math.sqrt(n);
    for(int i = 2; i <= sqrt; i++){
      if(n % i == 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int num = 4;
    System.out.print("Is " + num + " prime? ");
    System.out.println(primeNaive(num));

    int num2 = 7;
    System.out.print("Is " + num2 + " prime? ");
    System.out.println(primeNaive(num2));

    int num3 = 6;
    System.out.print("Is " + num3 + " prime? ");
    System.out.println(primeBetter(num3));

    int num4 = 11;
    System.out.print("Is " + num4 + " prime? ");
    System.out.println(primeBetter(num4));
  }
}
