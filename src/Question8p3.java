public class Question8p3 {

  public static int findMagicIndex(int[] array){
    if(array.length == 0) return -1;

    int lo = 0;
    int hi = array.length - 1;

    while (lo <= hi){
      int mid = lo + (hi - lo)/2;
      if(array[mid] < mid) lo = mid + 1;
      else if(array[mid] > mid) hi = mid - 1;
      else return mid;
    }
    return -1;
  }

  public static int magicFast(int[] array){
    return magicFast(array, 0, array.length - 1);
  }

  public static int magicFast(int[] array, int start, int end){
    if(end < start) {
      return -1;
    }
    int mid = (start + end) / 2;
    if(array[mid] == mid) return mid;
    else if(array[mid] > mid) return magicFast(array, start, mid - 1);
    else return magicFast(array, mid + 1, end);
  }

  public static int magicFastNonDistinct(int[] array){
    return magicFastNonDistinct(array, 0, array.length - 1);
  }

  public static int magicFastNonDistinct(int[] array, int start, int end){
    if(end < start){
      return -1;
    }

    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];
    if(midValue == midIndex) return midIndex;

    // Search left
    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = magicFastNonDistinct(array, start, leftIndex);
    if(left >= 0) return left;

    // Search right
    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = magicFastNonDistinct(array, rightIndex, end);

    return right;
  }

  public static void main(String[] args) {

    int[] array = {-2, -1, 0, 1, 4, 12, 16};
    System.out.println(findMagicIndex(array));

    int[] array2 = {-1, 1, 2, 4, 12, 16};
    System.out.println(magicFast(array2));

    int[] array3 = {-10, -5, 2, 4, 5, 7, 8, 9, 12, 13};
    System.out.println(magicFastNonDistinct(array3));
  }
}
