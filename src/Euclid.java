public class Euclid {

  private static int recursiveGCD(int p, int q){
    if(q == 0) return p;
    else return recursiveGCD(q, p % q);
  }

  private static int iterativeGDC(int p, int q){
    while (q != 0) {
      int temp = q;
      q = p % q;
      p = temp;
    }
    return p;
  }


  public static void main(String[] args) {
    int p = 21;
    int q = 68;
    System.out.println(recursiveGCD(p, q));
    System.out.println(iterativeGDC(p, q));
  }
}
