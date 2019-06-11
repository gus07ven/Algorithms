public class URLify {

  public static String toURL(String input, int strLength) {
    char[] inputStrCharArr = input.toCharArray();
    int ptr1 = strLength - 1;
    int ptr2 = inputStrCharArr.length - 1;

    for (int i = ptr1; i > 0; i--) {
      if (ptr2 >= i) {
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

  static void replaceSpaces(char[] str, int trueLength){
    int spaceCount = 0, index = 0, i = 0;
    for(i = 0; i < trueLength; i++){
      if(str[i] == ' '){
        spaceCount++;
      }
    }
    index = trueLength + spaceCount * 2;
    if(trueLength < str.length) str[trueLength] = '\0';
    for(i = trueLength - 1; i >= 0; i--){
      if(str[i] == ' '){
        str[index - 1] = '0';
        str[index - 2] = '2';
        str[index - 3] = '%';
        index = index - 3;
      } else {
        str[index - 1] = str[i];
        index--;
      }
    }
  }

  public static void main(String[] args) {
    String input = "John Smith  ";
    int strLength = 10;

    replaceSpaces(input.toCharArray(), strLength);
  }
}
