public class Exercise1p1p16 {

  public static String exR1(int n){
    if(n <= 0) return "";
    return exR1(n - 3) + n + exR1(n - 2) + n;
  }

  public static void main(String[] args) {
    int num = 6;
    System.out.println(exR1(num));
  }
}
