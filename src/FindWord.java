import java.util.HashSet;
import java.util.Set;

public class FindWord {

  public static String FindWord(String soFar, String rest, Set<String> dictionary){
    if(rest.isEmpty()){
      return dictionary.contains(soFar) ? soFar : "";
    } else {
      for (int i = 0; i < rest.length(); i++) {
        String remaining = rest.substring(0,i) + rest.substring(i + 1);
        String found = FindWord(soFar + rest.substring(i, i+1), remaining, dictionary);
        if(!found.isEmpty()) return found;
      }
    }
    return "";
  }

  public static void main(String[] args) {
    String word = "hye";
    Set<String> words = new HashSet<>();
    words.add("hey");
    System.out.println(FindWord("", word, words));
  }
}
