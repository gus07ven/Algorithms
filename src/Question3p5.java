public class Question3p5 {

  static void sort(Stack<Integer> source){
    Stack<Integer> helper = new Stack<Integer>();

    while(!source.isEmpty()){
      int temp = source.pop();
      while(!helper.isEmpty() && helper.peek() > temp){
        source.push(helper.pop());
      }
      helper.push(temp);
    }

    while(!helper.isEmpty()){
      source.push(helper.pop());
    }
  }

  public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
    st.push(6);
    st.push(14);
    st.push(3);
    st.push(19);
    st.push(8);
    sort(st);

  }
}
