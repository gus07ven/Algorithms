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

  public static void main(String[] args) {
    int input = 4;
    int input2 = 3;
    System.out.println(mySqrt(input2));
  }
}
