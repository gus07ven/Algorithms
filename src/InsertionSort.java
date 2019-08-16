public class InsertionSort {

  public static void sort(Comparable[] a){
    int N = a.length;
    for(int i = 0; i < N; i++){
      for(int j = i; j > 0; j--){
        if(Helper.less(a[j], a[j - 1])) Helper.exch(a, j, j - 1);
        else break;
      }
    }
  }

  public static void main(String[] args) {
    Integer[] nums = {7, 10, 5, 3, 8, 4, 2, 9, 6};
    InsertionSort.sort(nums);
    for (Object i : nums) {
      System.out.println(i);
    }
  }
}
