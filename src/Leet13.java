public class Leet13 {

  public static int romanToInt(String romanNum){
    if(romanNum.isEmpty()) return 0;

    char[] romanArr = romanNum.toCharArray();

    if(romanArr.length == 1) return singleToInteger(romanArr);
    return 0;
  }

  private static int singleToInteger(char[] numArr){
    int total = 0;
    char value = numArr[0];
    if(value == 'I') total += 1;
    else if(value == 'V') total += 5;
    else if(value == 'X') total += 10;
    else if(value == 'L') total += 50;
    else if(value == 'C') total += 100;
    else if(value == 'D') total += 500;
    else total += 1000;
    return total;
  }

  public static void main(String[] args) {
    String input = "I";
    System.out.println(romanToInt(input));
  }
}
