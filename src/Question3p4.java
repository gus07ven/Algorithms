import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Question3p4 {

  static class MyQueue {

    private Stack<Integer> addToStack;
    private Stack<Integer> removeFromStack;

    public MyQueue(){
      addToStack = new Stack<Integer>();
      removeFromStack = new Stack<Integer>();
    }

    public void enqueue(int value){
      if(addToStack.isEmpty() && removeFromStack.isEmpty()){
        addToStack.push(value);
      } else if(addToStack.isEmpty() && !removeFromStack.isEmpty()){
        shiftElements(removeFromStack, addToStack);
        addToStack.push(value);
      } else {
        addToStack.push(value);
      }
    }

    public int dequeue(){
      int element = 0;
      if(addToStack.isEmpty() && removeFromStack.isEmpty()) throw new EmptyStackException();
      if(!removeFromStack.isEmpty() && addToStack.isEmpty()){
        element = removeFromStack.pop();
      } else if(removeFromStack.isEmpty() && !addToStack.isEmpty()){
        shiftElements(addToStack, removeFromStack);
        element = removeFromStack.pop();
      }
      return element;
    }

    public int peek(){
      int element = 0;
      if(addToStack.isEmpty() && removeFromStack.isEmpty()) throw new EmptyStackException();
      if(addToStack.isEmpty() && !removeFromStack.isEmpty()){
        element = removeFromStack.peek();
      } else if(!addToStack.isEmpty() && removeFromStack.isEmpty()){
        shiftElements(addToStack, removeFromStack);
        element = removeFromStack.peek();
      }
      return element;
    }

    private void shiftElements(Stack source, Stack destination){
      if(source.isEmpty() && destination.isEmpty()) throw new EmptyStackException();
      if(source.isEmpty() && !destination.isEmpty()) throw new NoSuchElementException("Source stack is empty");
      if(!source.isEmpty() && destination.isEmpty()){
        int stackSize = source.size();
        for(int i = 0; i < stackSize; i++){
          destination.push(source.pop());
        }
      }
    }
  }

  public static void main(String[] args) {
    MyQueue mq = new MyQueue();
    mq.enqueue(1);
    mq.enqueue(2);
    mq.enqueue(3);
    mq.enqueue(4);
    System.out.println(mq.dequeue());
    System.out.println(mq.dequeue());
    System.out.println(mq.peek());
    mq.enqueue(17);
    System.out.println(mq.peek());
  }
}
