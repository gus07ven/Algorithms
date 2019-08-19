public class QuickSort3Way {

  private static void sort(Comparable[] a, int lo, int hi){
    if(hi <= lo) return;
    int lt = lo;
    int gt = hi;
    Comparable v = a[lo];
    int i = lo;
    while(i <= gt){
      int cmp = a[i].compareTo(v);
      if      (cmp < 0) Helper.exch(a, lt++, i++);
      else if (cmp > 0) Helper.exch(a, i, gt--);
      else    i++;
    }
    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
  }

  public static void main(String[] args) {
    Integer[] nums = {5, 2, 9, 12, 19, 3, 1, 7};
    sort(nums, 0, nums.length - 1);
    for (Integer i : nums){
      System.out.println(i);
    }
  }
}
