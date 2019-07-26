public class Leet13 {

  public static int romanToInt(String romanNum){
    if(romanNum.isEmpty()) return 0;

    char[] romanArr = romanNum.toCharArray();

    if(romanArr.length == 1) return singleToInteger(romanArr[0]);
    else{
      int total = 0;
      for(int i = 0; i < romanArr.length; i++){
        if(i < romanArr.length - 1){
          if(romanArr[i] == 'I' && (romanArr[i + 1] == 'V' || romanArr[i + 1] == 'X')){
            if(romanArr[i + 1] == 'V') {
              total += 4;
              i++;
              continue;
            }
            if(romanArr[i + 1] == 'X') {
              total += 9;
              i++;
              continue;
            }
          } else if(romanArr[i] == 'X' && (romanArr[i + 1] == 'L' || romanArr[i + 1] == 'C')){
            if(romanArr[i + 1] == 'L'){
              total += 40;
              i++;
              continue;
            }
            if(romanArr[i + 1] == 'C'){
              total += 90;
              i++;
              continue;
            }
          } else if(romanArr[i] == 'C' && (romanArr[i + 1] == 'D' || romanArr[i + 1] == 'M')){
            if(romanArr[i + 1] == 'D') {
              total += 400;
              i++;
              continue;
            }
            if(romanArr[i + 1] == 'M'){
              total += 900;
              i++;
              continue;
            }
          } else if(romanArr[i] == 'I' && !(romanArr[i + 1] == 'V' || romanArr[i + 1] == 'X')){
            total += singleToInteger(romanArr[i]);
          } else if(romanArr[i] == 'X' && !(romanArr[i + 1] == 'L' || romanArr[i + 1] == 'C')){
            total += singleToInteger(romanArr[i]);
          } else if(romanArr[i] == 'C' && !(romanArr[i + 1] == 'D' || romanArr[i + 1] == 'M')){
            total += singleToInteger(romanArr[i]);
          } else {
            total += singleToInteger(romanArr[i]);
          }
        } else {
          total += singleToInteger(romanArr[i]);
        }
      }
      return total;
    }
  }

  private static int singleToInteger(char num){
    int total = 0;
    if(num == 'I') total += 1;
    else if(num == 'V') total += 5;
    else if(num == 'X') total += 10;
    else if(num == 'L') total += 50;
    else if(num == 'C') total += 100;
    else if(num == 'D') total += 500;
    else total += 1000;
    return total;
  }

  public static void main(String[] args) {
    String input = "MCMXCIV";
    System.out.println(romanToInt(input));
  }
}
