public class Leet69 {

  public static int mySqrt(int x) {
    if(x == 0) return 0;

    int num = 0;
    for(int i = 0; i <= x; i++){
      if((num * num) == x) break;
      else if((num * num) > x){
        num -= 1;
        break;
      }
      else num++;
    }
    return num;
  }

  public static int mySqrt2(int x){
    if (x == 0) return 0;
    for (int i = 1; i <= x / i; i++)
      if (i <= x / i && (i + 1) > x / (i + 1))
        return i;
    return -1;
  }

  public static void main(String[] args) {
    int input = 8;
    System.out.println(mySqrt2(input));
  }
}
