import java.util.NoSuchElementException;

public class GenQueueArr<T> {

  private T[] q;
  private int head;
  private int tail;
  private int n;

  public GenQueueArr(int capacity){
    q = (T[]) new Object[capacity];
    head = 0;
    tail = 0;
    n = 0;
  }

  public void enqueue(T item){
    if(n == q.length) throw new NoSuchElementException("Queue overflow");
    q[tail] = item;
    tail++;
    if(tail == q.length) tail = 0;
    n++;
  }

  public T dequeue(){
    if(isEmpty()) throw new NoSuchElementException("Queue underflow");
    T retVal = q[head];
    q[head] = null;
    n--;
    head++;
    if(head == q.length) head = 0;
    return retVal;
  }

  public boolean isEmpty(){
    return n == 0;
  }

  public T peek(){
    if(isEmpty()) throw new NoSuchElementException("Queue underflow");
    return q[head];
  }

  public static void main(String[] args) {
    GenQueueArr gqa = new GenQueueArr(3);
    gqa.enqueue("Gustavo");
    gqa.enqueue("Manuel");
    gqa.enqueue("Mariano");
    System.out.println(gqa.n);
    System.out.println(gqa.q.length);
    System.out.println(gqa.head);
    System.out.println(gqa.tail);
    System.out.println(gqa.dequeue());
  }
}
