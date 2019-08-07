public class Leet69 {

  public static int mySqrtLinear(int x) {
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

  public static int mySqrtSqrtComplexity(int x){
    if (x == 0) return 0;
    for (int i = 1; i <= x / i; i++)
      if (i <= x / i && (i + 1) > x / (i + 1))
        return i;
    return -1;
  }

  // Using a modification of binary search
  public static int mySqrtLogComplexity(int x){
    if(x == 0) return 0;
    int start = 1;
    int end = x;
    while(start < end){
      int mid = start + (end - start) / 2;
      if(mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
      else if(mid > x / mid) end = mid;
      else start = mid + 1;
    }
    return start;
  }

  public static void main(String[] args) {
    int input = 8;
    System.out.println(mySqrtLogComplexity(input));
  }
}
