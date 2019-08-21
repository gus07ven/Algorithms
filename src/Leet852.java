public class Leet852 {

  public static int peakIndexInMountainArray(int[] A) {
    return findPeak(A, 0, A.length - 1);
  }

  public static int findPeak(int[] A, int lo, int hi){
    return -1;
  }

  public static void main(String[] args) {
    int[] mountain = {0, 1, 0};
    int[] mountain2 = {0, 2, 1};
    int[] mountain3 = {0, 1, 2, 3, 4, 1, 0};
    System.out.println(peakIndexInMountainArray(mountain));
    System.out.println(peakIndexInMountainArray(mountain2));
    System.out.println(peakIndexInMountainArray(mountain3));
  }
}
