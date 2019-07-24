public class Primality {

  public static boolean primeNaive(int n){
    if(n < 2) return false;

    for(int i = 2; i < n; i++){
      if(n % i == 0){
        return false;
      }
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
  }
}
