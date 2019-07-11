import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenStackArr<T> implements Iterable<T> {

  private T[] s;
  private int top;

  public GenStackArr(){
    s = (T[]) new Object[4];
    top = 0;
  }

  public boolean isEmpty(){
    return top == 0;
  }

  public int size(){
    return top;
  }

  private void resize(int capacity){
    if(capacity >= top){
      T[] temp = (T[]) new Object[capacity];
      for(int i = 0; i < top; i++){
        temp[i] = s[i];
      }
      s = temp;
    }
  }

  public void push(T item){
    if(top == s.length) resize(2 * s.length);
    s[top++] = item;
  }

  public T pop(){
    if(isEmpty()) throw new EmptyStackException();
    T retVal = s[top - 1];
    s[top - 1] = null;
    top--;
    if(top > 0 && top == s.length/4) resize(s.length/2);
    return retVal;
  }

  public T peek(){
    if(isEmpty()) throw new EmptyStackException();
    return s[top - 1];
  }

  public Iterator<T> iterator(){
    return new StackIterator();
  }

  private class StackIterator implements Iterator<T> {
    private int i;

    public StackIterator(){
      i = top - 1;
    }

    public boolean hasNext(){
      return i >= 0;
    }

    public void remove(){
      throw new UnsupportedOperationException();
    }

    public T next(){
      if(!hasNext()) throw new NoSuchElementException();
      return s[i--];
    }
  }

  public static void main(String[] args) {
    GenStackArr<String> stack = new GenStackArr<String>();
    while(!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if(!item.equals("-")) stack.push(item);
      else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
    }
    StdOut.println("(" + stack.size() + " left on stack)");
  }
}
