import java.util.EmptyStackException;

public class GenStackArr<T> {

  private T[] s;
  private int top;

  public GenStackArr(int capacity){
    s = (T[]) new Object[capacity];
    top = 0;
  }

  public boolean isEmpty(){
    return top == 0;
  }

  public void push(T item){
    if(top == s.length){
      throw new StackOverflowError();
    } else {
      s[top++] = item;
    }
  }

  public T pop(){
    if(isEmpty()){
      throw new EmptyStackException();
    } else {
      T retVal = s[top - 1];
      s[top - 1] = null;
      top--;
      return retVal;
    }
  }

  public static void main(String[] args) {

    GenStackArr gsa = new GenStackArr(3);
    System.out.println(gsa.isEmpty());
    gsa.push("Gustavo");
    gsa.push("Luis");
    gsa.push("Mariano");
    System.out.println(gsa.pop());
    System.out.println(gsa.pop());
    System.out.println(gsa.isEmpty());
  }
}
