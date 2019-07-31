public class Leet20 {

  public static boolean isValid(String s) {
    if(s.isEmpty()) return true;
    char[] letters = s.toCharArray();
    Stack<Character> st = new Stack<>();
    for(Character ch : letters){
      if(!st.isEmpty() && st.peek() == (ch - 1)) st.pop();
      else if(!st.isEmpty() && st.peek() == (ch - 2)) st.pop();
      else if(!st.isEmpty() && st.peek() == (ch - 2)) st.pop();
      else st.push(ch);
    }
    return st.isEmpty();
  }

  public static void main(String[] args) {
    String str = "";
    System.out.println(isValid(str));
  }
}
