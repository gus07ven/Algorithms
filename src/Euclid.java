public class Euclid {

  public static int recursiveGCD(int p, int q){
    if(q == 0) return p;
    else
      System.out.println("p: " + p);
      System.out.println("p % q: " + (p % q));
      return gcd(q, p % q);
  }

  public static void main(String[] args) {
    int p = 102;
    int q = 68;
    System.out.println(recursiveGCD(p, q));
  }
}
