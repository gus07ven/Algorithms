public class URLify {

  public static String toURL(String input, int strLength) {
    char[] inputStrCharArr = input.toCharArray();
    int ptr1 = strLength - 1;
    int ptr2 = inputStrCharArr.length - 1;

    for (int i = ptr1; i > 0; i--) {
      if (ptr2 > i) {
        if (inputStrCharArr[i] != ' ') {
          inputStrCharArr[ptr2] = inputStrCharArr[i];
          inputStrCharArr[i] = ' ';
          ptr2--;
        } else {
          inputStrCharArr[ptr2] = '0';
          inputStrCharArr[ptr2 - 1] = '2';
          inputStrCharArr[ptr2 - 2] = '%';
          ptr2 = ptr2 - 3;
        }
      }
    }
    if (ptr2 == 2) {
      inputStrCharArr[ptr2] = '0';
      inputStrCharArr[ptr2 - 1] = '2';
      inputStrCharArr[ptr2 - 2] = '%';
    }
    return new String(inputStrCharArr);
  }

  public static void main(String[] args) {
    String input = "Mr John Smith    ";
    int strLength = 13;

    System.out.println(toURL(input, strLength));
  }
}
