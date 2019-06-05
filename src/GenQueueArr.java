import java.util.NoSuchElementException;

public class GenQueueArr<T> {

  private T[] q;
  private int first;
  private int last;
  private int numElem;

  public GenQueueArr(int capacity){
    q = (T[]) new Object[capacity];
    first = 0;
    last = 0;
    numElem = 0;
  }

  public void enqueue(T item){
    if(first == q.length){
      throw new NoSuchElementException("Queue overflow");
    }
    q[first] = item;
    first++;
    numElem++;
  }

  public T dequeue(){
    if(isEmpty()){
      throw new NoSuchElementException("Queue underflow");
    }
    T retVal = q[last];
    q[last] = null;
    last++;
    numElem--;
    return retVal;
  }

  public boolean isEmpty(){
    return numElem == 0;
  }

  public static void main(String[] args) {
    GenQueueArr gqa = new GenQueueArr(3);
    gqa.enqueue("Gustavo");
    gqa.enqueue("Luis");
    gqa.enqueue("Mariano");
    System.out.println(gqa.isEmpty());
    System.out.println(gqa.dequeue());
    System.out.println(gqa.dequeue());
    System.out.println(gqa.dequeue());
  }
}
