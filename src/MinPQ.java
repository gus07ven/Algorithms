import java.util.NoSuchElementException;

public class MinPQ<T extends Comparable<T>> {

  private T[] pq;
  private int numItems;

  public MinPQ(int capacity){
    pq = (T[]) new Comparable[capacity + 1];
  }

  public boolean isEmpty(){
    return numItems == 0;
  }

  public T min(){
    if(isEmpty()) throw new NoSuchElementException("Min priority queue underflow");
    return pq[1];
  }

  public void insert(T key){
    if(numItems == pq.length - 1) throw new NoSuchElementException("Min priority queue overflow");
    pq[++numItems] = key;
    swim(numItems);
  }

  public T delMin(){
    if(isEmpty()) throw new NoSuchElementException("Min priority queue underflow");
    T min = pq[1];
    exchange(1, numItems);
    sink(1);
    return min;
  }

  private void swim(int key){
    while(key > 1 && greater(key / 2, key)){
      exchange(key, key / 2);
      key = key / 2;
    }
  }

  private void sink(int key){
    while(2*key <= numItems){
      int child = 2 * key;
      if(child < numItems && greater(child, child + 1)) child++;
      if(!greater(key, child)) break;
      exchange(key, child);
      key = child;
    }
  }

  private boolean greater(int key1, int key2){
    return pq[key1].compareTo(pq[key2]) > 0;
  }

  private void exchange(int key1, int key2){
    T temp = pq[key1];
    pq[key1] = pq[key2];
    pq[key2] = temp;
  }

  public static void main(String[] args) {
    Comparable[] keys = {8, 7, 6, 5, 4, 3, 2, 1};
    MinPQ pq = new MinPQ(8);
    for(int i = 0; i < keys.length; i++){
      pq.insert(keys[i]);
    }
    System.out.println(pq.delMin());
    System.out.println(pq.min());
  }
}
