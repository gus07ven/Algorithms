public class QuickSort2 {

  private static final int CUTOFF = 10;

  public static void sort(Comparable[] a){
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi){
    if(hi <= lo) return;
    int m = median3(a, lo, lo + (hi - lo) / 2, hi); // Opt 2: pivot item = median
    Helper.exch(a, lo, m);

    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private static int median3(Comparable[] a, int i, int j, int k) {
    return (Helper.less(a[i], a[j]) ?
            (Helper.less(a[j], a[k]) ? j : Helper.less(a[i], a[k]) ? k : i) :
            (Helper.less(a[k], a[j]) ? j : Helper.less(a[k], a[i]) ? k : i));
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

  public static void main(String[] args) {
    Character[] text = {'Q','U','I','C','K','S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    QuickSort2.sort(text);
    for (Object i : text) {
      System.out.println(i);
    }
  }
}
