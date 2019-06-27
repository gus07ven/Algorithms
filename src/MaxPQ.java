import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxPQ<T> {

  private T[] pq;                     // Store items at indices 1 to n
  private int numItems;               // Number of items on priority queue
  private Comparator<T> comparator;   // Optional comparator

  public MaxPQ(T[] keys){
    numItems = keys.length;
    pq = (T[]) new Object[keys.length + 1];
    for(int i = 0; i < numItems; i++){
      pq[i+1] = keys[i];
    }
    for(int k = numItems / 2; k >= 1; k--){
      sink(k);
    }
    assert isMaxHeap();
  }

  public boolean isEmpty(){
    return numItems == 0;
  }

  public int size(){
    return numItems;
  }

  public T max(){
    if(isEmpty()) throw new NoSuchElementException("Priority queue underflow");
    return pq[1];
  }

  public void insert(T key){
    if(numItems == pq.length - 1) resize(2 * pq.length);

    pq[++numItems] = key;
    swim(numItems);
    assert isMaxHeap();
  }

  public T delMax(){
    if(isEmpty()) throw new NoSuchElementException("Priority queue underflow");
    T max = pq[1];
    exchange(1, numItems--);
    sink(1);
    pq[numItems + 1] = null; // to avoid loitering
    if((numItems > 0) && numItems == (pq.length - 1) / 4) resize(pq.length / 2);
    return max;
  }

  private void swim(int key){
    while(key > 1 && less(key / 2, key)){
      exchange(key, key / 2 );
      key = key / 2;
    }
  }

  private void sink(int key){
    while(2*key <= numItems){
      int child = 2 * key;
      if(child < numItems && less(child, child + 1)) child++;
      if(!less(key, child)) break;
      exchange(key, child);
      key = child;
    }
  }

  private boolean less(int key, int key2){
    if(comparator == null) {
      return ((Comparable<T>) pq[key]).compareTo(pq[key2]) < 0;
    } else {
      return comparator.compare(pq[key], pq[key2]) < 0;
    }
  }

  private void exchange(int key, int key2){
    T swap = pq[key];
    pq[key] = pq[key2];
    pq[key2] = swap;
  }

  private boolean isMaxHeap(){
    return isMaxHeap(1);
  }

  private boolean isMaxHeap(int key){
    if(key > numItems) return true;
    int left = 2 * key;
    int right = 2 * key + 1;
    if(left <= numItems && less(key, left)) return false;
    if(right <= numItems && less(key, right)) return false;
    return isMaxHeap(left) && isMaxHeap(right);
  }

  private void resize(int capacity){
    if(capacity > numItems){
      T[] temp = (T[]) new Object[capacity];
      for(int i = 1; i <= numItems; i++){
        temp[i] = pq[i];
      }
      pq = temp;
    }
  }

  public static void main(String[] args) {
    Object[] keys = {1, 2, 3, 4, 5, 6, 7};
    MaxPQ pq = new MaxPQ(keys);
    pq.insert(9);
    System.out.println(pq.delMax());
    System.out.println(pq.max());
  }
}