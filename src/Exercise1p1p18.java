import java.util.Arrays;

public class Exercise1p1p18 {

  public static int mystery(int a, int b){
    if(b == 0) return 0;
    if(b % 2 == 0) return mystery(a + a, b / 2);
    return mystery(a + a, b / 2) + a;
  }

  public static int mysteryProduct(int a, int b){
    if(b == 0) return 1;
    if(b % 2 == 0) return mystery(a * a, b / 2);
    return mystery(a * a, b / 2) * a;
  }

  public static void main(String[] args) {
    int a = 2;
    int b = 25;
    System.out.println(mystery(a, b));
    System.out.println(mysteryProduct(a, b));
  }
}
