public class RecurRev {

  public static int getTriNum(int num){
    if(num == 1){
      return 1;
    }
    return(num + getTriNum(num - 1));
  }

  public static int getFactorial(int num){
    if(num == 1){
      return 1;
    }
    return num * getFactorial(num - 1);
  }

  public static void main(String[] args) {
    System.out.println(getTriNum(6));
    System.out.println(getFactorial(6));
  }
}
