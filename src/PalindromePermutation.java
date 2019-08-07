import java.util.HashMap;

public class PalindromePermutation {

  static boolean isPalindromePermutation(String str){
    if(str.isEmpty()) return false;

    char[] strArr= str.toLowerCase().trim().toCharArray();
    HashMap<Character, Integer> letters = new HashMap<>();
    int pairs = 0;
    int ones = 0;
    int whiteSpaces = 0;

    for(char c : strArr){
      if(letters.containsKey(c)){
        if(letters.get(c) == 2) return false;
        else letters.replace(c, letters.get(c) + 1);
             pairs++;
      } else {
        if(Character.isWhitespace(c)) {
          whiteSpaces++;
          continue;
        }
        letters.put(c, 1);
        ones++;
      }
    }

    if((ones - pairs) > 1) return false;

    return (((pairs * 2) + (ones - pairs)) == (strArr.length - whiteSpaces));
  }

  static boolean isPermutationOfPalindrome(String phase){
    int[] table = buildCharFrequencyTable(phase);
    return checkMaxOneOdd(table);
  }

  static boolean isPermutationOfPalindromeTwo(String phrase){
    int countOdd = 0;
    int z = Character.getNumericValue('z');
    int a = Character.getNumericValue('a');
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

    for(char c : phrase.toCharArray()){
      int x = getCharNumber(c);
      if(x != -1){
        table[x]++;
        if(table[x] % 2 == 1){
          countOdd++;
        } else {
          countOdd--;
        }
      }
    }
    return countOdd <= 1;
  }

  static boolean isPermutationOfPalindromeThree(String phrase){
    int bitVector = createBitVector(phrase);
    return bitVector == 0 || checkExactlyOneBitSet(bitVector);
  }

  static int createBitVector(String phrase){
    int bitVector = 0;
    for(char c : phrase.toCharArray()){
      int x = getCharNumber(c);
      bitVector = toggle(bitVector, x);
    }
    return bitVector;
  }

  static int toggle(int bitVector, int index){
    if(index < 0) return bitVector;

    int mask = 1 << index;
    if((bitVector & mask) == 0){
      bitVector |= mask;
    } else {
      bitVector &= ~mask;
    }
    return bitVector;
  }

  static boolean checkExactlyOneBitSet(int bitVector){
    return (bitVector & (bitVector - 1)) == 0;
  }

  static boolean checkMaxOneOdd(int[] table){
    boolean foundOdd = false;
    for(int count : table) {
      if(count % 2 == 1){
        if(foundOdd){
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  static int getCharNumber(Character c){
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if(a <= val && val <= z){
      return val - a;
    }
    return -1;
  }

  static int[] buildCharFrequencyTable(String phrase){
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

    for(char c : phrase.toCharArray()){
      int x = getCharNumber(c);
      if(x != -1){
        table[x]++;
      }
    }
    return table;
  }


  public static void main(String[] args) {
    String odd = "taco cat";
    String even = "roor";

    System.out.println(isPermutationOfPalindrome(odd));
    System.out.println(isPalindromePermutation(even));
  }
}
