import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

  private Node<T> first;
  private int n;

  private static class Node<T> {
    private T item;
    private Node<T> next;
  }

  public Stack() {
    first = null;
    n = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void push(T item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    n++;
  }

  public T pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    T value = first.item;
    first = first.next;
    n--;
    return value;
  }

  public T peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    return first.item;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    for (T item : this) {
      s.append(item);
      s.append(' ');
    }
    return s.toString();
  }

  public Iterator<T> iterator() {
    return new ListIterator(first);
  }

  private class ListIterator implements Iterator<T> {
    private Node<T> current;

    public ListIterator(Node<T> first) {
      current = first;
    }

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public T next() {
      if (!hasNext()) throw new NoSuchElementException();
      T item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    Stack<String> stack = new Stack<String>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-")) {
        stack.push(item);
      } else if (!stack.isEmpty()) {
        StdOut.print(stack.pop() + " ");
      }
      StdOut.println("(" + stack.size() + " left of stack)");
    }
  }
}

