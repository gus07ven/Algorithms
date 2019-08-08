import java.util.HashMap;

public class Leet771 {

  public static int numJewelsInStones(String J, String S) {
    if(J.length() == 0 || S.length() == 0) return 0;

    HashMap<Character,Integer> jewels = new HashMap<>();
    for(Character c : J.toCharArray()){
      jewels.put(c, 0);
    }

    char[] stones = S.toCharArray();
    int numJewels = 0;
    for(int i = 0; i < stones.length; i++){
      if(jewels.containsKey(stones[i])){
        numJewels++;
      }
    }
    return numJewels;
  }

  public static void main(String[] args) {
    String J = "aA";
    String S = "aAAbbbbb";
    System.out.println(numJewelsInStones(J, S));
  }
}
