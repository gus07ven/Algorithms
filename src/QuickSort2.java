public class QuickSort2 {

  public static void sort(Comparable[] a){
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi){
    if(hi <= lo) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi){
    int i = lo;
    int j = hi + 1;
    while(true){
      while(Helper.less(a[++i], a[lo])){
        if(i == hi) break;
      }
      while(Helper.less(a[lo], a[--j])){
        if(j == lo) break;
      }
      if(i >= j) break;     // Check if pointers cross
      Helper.exch(a, i, j);
    }
    Helper.exch(a, lo, j);  // Swap with partitioning item
    return j;
  }
}
