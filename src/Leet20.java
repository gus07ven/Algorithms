public class Leet20 {

  public static boolean isValid(String s) {
    if (s.isEmpty()) return true;
    char[] letters = s.toCharArray();
    Stack<Character> st = new Stack<>();
    for (Character ch : letters) {
      if (!st.isEmpty() && st.peek() == (ch - 1)) st.pop();
      else if (!st.isEmpty() && st.peek() == (ch - 2)) st.pop();
      else if (!st.isEmpty() && st.peek() == (ch - 2)) st.pop();
      else st.push(ch);
    }
    return st.isEmpty();
  }

  public static boolean isValidOpt(String s) {
    if (s.isEmpty()) return true;
    if (s.length() % 2 != 0) return false;

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == ')' || ch == ']' || ch == '}') {
        if (stack.isEmpty()) return false;
        if (ch == ')' && stack.pop() != '(') return false;
        if (ch == ']' && stack.pop() != '[') return false;
        if (ch == '}' && stack.pop() != '{') return false;
      } else stack.push(ch);
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String str = "";
    System.out.println(isValid(str));
    System.out.println(isValidOpt(str));
  }
}
