public class Leet852 {

  private static int peakIndexInMountainArray(int[] A) {
    return findPeak(A, 0, A.length - 1);
  }

  private static int findPeak(int[] A, int lo, int hi){
    if(hi >= lo){
      int mid = lo + (hi - lo)/2;
      if((A[mid - 1] < A[mid]) && (A[mid] > A[mid + 1])) return mid;
      else if((A[mid - 1] > A[mid]) && (A[mid] > A[mid + 1])) return findPeak(A, lo, mid - 1);
      else if((A[mid - 1] < A[mid]) && (A[mid] < A[mid + 1])) return findPeak(A, mid + 1, hi);
    }
    return -1;
  }

  public static int peakIndexInMountainArrayIterative(int[] A) {
    int lo = 0, hi = A.length - 1;
    while (lo < hi) {
      int mi = lo + (hi - lo) / 2;
      if (A[mi] < A[mi + 1])
        lo = mi + 1;
      else
        hi = mi;
    }
    return lo;
  }


  public static void main(String[] args) {
    int[] mountain = {0, 1, 0};
    int[] mountain2 = {0, 2, 1};
    int[] mountain3 = {0, 1, 2, 3, 4, 1, 0};
    System.out.println(peakIndexInMountainArray(mountain));
    System.out.println(peakIndexInMountainArray(mountain2));
    System.out.println(peakIndexInMountainArray(mountain3));
    System.out.println(peakIndexInMountainArrayIterative(mountain));
    System.out.println(peakIndexInMountainArrayIterative(mountain2));
    System.out.println(peakIndexInMountainArrayIterative(mountain3));
  }
}
