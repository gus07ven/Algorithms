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

  public static void main(String[] args) {
    UnorderedMaxPQ umpq = new UnorderedMaxPQ(10);
    umpq.insert(5);
    umpq.insert(17);
    System.out.println(umpq.isEmpty());
  }
}
