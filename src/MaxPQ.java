import java.util.Comparator;
import java.util.Iterator;

public class MaxPQ<T> implements Iterable<T>{

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

  private void sink(int key){
    while(2*key <= numItems){
      int child = 2 * key;
      if(child < numItems && less(child, child + 1)) child++;
      if(!less(key, child)) break;
      exch(key, child);
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

  public Iterator<T> iterator(){
    return null;
  }
}