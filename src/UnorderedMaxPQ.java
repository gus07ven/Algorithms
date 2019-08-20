// Good implementation for a small priority queue.

public class UnorderedMaxPQ<Key extends Comparable<Key>> {

  private Key[] pq;
  private int N;

  public UnorderedMaxPQ(int capacity){
    pq = (Key[]) new Comparable[capacity];
  }

  public boolean isEmpty(){
    return N == 0;
  }

  public void insert(Key x){
    pq[N++] = x;
  }

  public Key delMax(){
    int max = 0;
    for(int i = 1; i < N; i++){
      if(Helper.less(max, i)) max = i;
    }
    Helper.exch(pq, max, N-1);
    return pq[--N];
  }

  public static void main(String[] args) {
    UnorderedMaxPQ umpq = new UnorderedMaxPQ(10);
    umpq.insert(5);
    umpq.insert(17);
    System.out.println(umpq.isEmpty());
  }
}
