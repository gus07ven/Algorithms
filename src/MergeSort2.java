public class MergeSort2 {

  private static final int CUTOFF = 7;

  public static void sort(Comparable[] a){
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
    if(hi <= lo + CUTOFF - 1){
      InsertionSort.sort(a, lo, hi);     // First optimization
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    if(!Helper.less(a[mid + 1], a[mid])) return;    // Second optimization: handle array already sorted.
    merge(a, aux, lo, mid, hi);
  }

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
    for(int i = lo; i <= hi; i++){
      aux[i] = a[i];
    }

    int leftPtr = lo, rightPtr = mid + 1;
    for(int current = lo; current <= hi; current++){
      if(leftPtr > mid)                                      a[current] = aux[rightPtr++];
      else if(rightPtr > hi)                                 a[current] = aux[leftPtr++];
      else if(Helper.less(aux[rightPtr], aux[leftPtr]))      a[current] = aux[rightPtr++];
      else                                                   a[current] = aux[leftPtr++];
    }
  }

  public static void main(String[] args) {
    Character[] text = {'S','O','R','T','E','X','A','M','P','L','E'};
    MergeSort2.sort(text);
    for (Object i : text) {
      System.out.println(i);
    }
  }
}
