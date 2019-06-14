import java.util.ArrayList;
import java.util.Arrays;

public class StrCompressor {

  // Assumption: uppercase and lowercase chars are considered the same character.
  static String compressStr(String original){
    original = original.toLowerCase();
    ArrayList<String> compressed = new ArrayList<>();
    int index = 0;
    int counter = 0;
    char curr = original.charAt(0);

    for(int i = 0; i < original.length(); i++){
      if(compressed.size() > original.length()) return original;
      if(original.charAt(i) == curr){
        counter++;
      }
      else {
        compressed.add(Character.toString(curr));
        compressed.add(Integer.toString(counter));
        index += 2;
        counter = 1;
        curr = original.charAt(i);
      }
    }
    compressed.add(Character.toString(curr));
    compressed.add(Integer.toString(counter));

    return compressed.toString();
  }

  static String compress(String str){
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;

    for(int i = 0; i < str.length(); i++){
      countConsecutive++;

      if(compressed.length() > str.length()) return str;

      if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
  }

  public static void main(String[] args) {
    String original = "abcdefg";

    System.out.println(compress(original));
  }
}
