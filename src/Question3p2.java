import java.util.EmptyStackException;

public class Question3p2 {

  static class StackMin extends Stack<NodeMin> {

    public void push(int value){
      if(this.isEmpty()){
        NodeMin node = new NodeMin(value);
        node.min = Integer.MAX_VALUE;
        super.push(node);
      }
      int min = Math.min(value, this.peek().min);
      NodeMin node = new NodeMin(value);
      node.min = min;
      super.push(node);
    }

    public NodeMin pop(){
      if(this.isEmpty()) throw new EmptyStackException();
      return super.pop();
    }

    public NodeMin peek2(){
      return super.peek();
    }
  }

  public static void main(String[] args) {
//    StackWithMin stack = new StackWithMin();
//    StackWithMin2 stack2 = new StackWithMin2();
//    int[] array = {2, 1, 3, 1};
//    for (int value : array) {
//      stack.push(value);
//      stack2.push(value);
//      System.out.print(value + ", ");
//    }
//    System.out.println('\n');
//    for (int i = 0; i < array.length; i++) {
//      System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
//      System.out.println("New min is " + stack.min() + ", " + stack2.min());
//    }
    StackMin st = new StackMin();
    int[] array = {4, 7, 2, 1, 3, 1, 5};
    for(int value : array){
      st.push(value);
      System.out.println(value + " ");
    }
    System.out.println();
    System.out.println("Current min is " + st.peek2().min);
    for(int i = 0; i < array.length; i++){
      System.out.println("Popped " + st.pop().data);
      System.out.println("New min is " + st.peek2().min);
    }
  }
}
