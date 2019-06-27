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

  public void insert(T key){
    if(numItems == pq.length - 1) throw new NoSuchElementException("Min priority queue overflow");
    pq[++numItems] = key;
    swim(numItems);
  }

  private void swim(int key){
    while(key > 1 && greater(key / 2, key)){
      exchange(key, key / 2);
      key = key / 2;
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
}
