
public class MyQueue2<T> {

  Stack<T> stackNewest, stackOldest;

  public MyQueue2(){
    stackNewest = new Stack<T>();
    stackOldest = new Stack<T>();
  }

  public int size(){
    return stackNewest.size() + stackOldest.size();
  }

  public void add(T value){
    stackNewest.push(value);
  }

  private void shiftStacks(){
    if(stackOldest.isEmpty()){
      while(!stackNewest.isEmpty()){
        stackOldest.push(stackNewest.pop());
      }
    }
  }

  public T peek(){
    shiftStacks();
    return stackOldest.peek();
  }

  public T remove(){
    shiftStacks();
    return stackOldest.pop();
  }


  public static void main(String[] args) {
    MyQueue2<Integer> mq = new MyQueue2<>();
    mq.add(1);
    mq.add(7);
    mq.add(17);
    System.out.println("Peek: " + mq.peek());
    System.out.println("Remove " + mq.remove());
    System.out.println("Peek: " + mq.peek());
    System.out.println("Remove " + mq.remove());
    mq.add(77);
    System.out.println("Peek after adding 77: " + mq.peek());
  }
}
