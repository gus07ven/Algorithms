import java.util.Comparator;
import java.util.Iterator;

public class MaxPQ<T> implements Iterable<T>{

  private T[] pq;                     // Store items at indices 1 to n
  private int n;                      // Number of items on priority queue
  private Comparator<T> comparator;   // Optional comparator

  public MaxPQ(T[] keys){
    n = keys.length;
    pq = (T[]) new Object[keys.length + 1];
    for(int i = 0; i < n; i++){
      pq[i+1] = keys[i];
    }
    for(int k = n/2; k >= 1; k--){
      sink(k);
    }
    assert isMaxHeap();
  }

  public Iterator<T> iterator(){
    return null;
  }
}