public class Leet371 {

  public static int sum(int a, int b){
    while(b!=0){
      int c = a & b;
      a = a ^ b;
      b = c << 1;
    }
    return a;
  }

  public static void main(String[] args) {
    System.out.println(sum(2, 3));
  }
}
